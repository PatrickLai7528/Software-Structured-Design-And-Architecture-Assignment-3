package logic.strategypattern;

import dao.BookDao;
import dao.BorrowRecordDao;
import dao.UserDao;
import daoImpl.BookDaoImpl;
import daoImpl.BorrowRecordDaoImpl;
import daoImpl.UserDaoImpl;
import model.BookEntity;
import model.BorrowrecordEntity;
import model.UserEntity;
import util.DateUtil;

import java.util.Date;

/**
 * Created by 82646 on 2019/1/23.
 * 不同类型的用户借书的实现和同时借书的上限是不同的
 * 研究生2个月
 */
public class GraduateBorrow implements Borrowable{

    private BorrowRecordDao borrowRecordDao = new BorrowRecordDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    //返回0是正常 返回1是表示用户达到最大可借数目 返回2是表示库存为0
    @Override
    public int doBorrow(UserEntity user,BookEntity book) {
        int nowBorrowNum = user.getNowborrownum();
        int maxBorrowNum = user.getMaxborrownum();

        if(nowBorrowNum == maxBorrowNum){
            return 1;
        }

        if(book.getRemainquantity() == 0){
            return 2;
        }

        user.setNowborrownum(user.getNowborrownum() + 1);
        userDao.updateUserInfo(user);   //保存用户信息

        BorrowrecordEntity record = new BorrowrecordEntity();
        record.setBorrowdate(DateUtil.getNewDate(new Date()));
        record.setBid(book.getBid());
        record.setUid(user.getUserid());
        record.setShouldreturndate(DateUtil.addMonth(record.getBorrowdate(),2));

        borrowRecordDao.addBorrowRecord(record);

        book.setRemainquantity(book.getRemainquantity() - 1);
        bookDao.updateBookInfo(book);

        return 0;
    }
}
