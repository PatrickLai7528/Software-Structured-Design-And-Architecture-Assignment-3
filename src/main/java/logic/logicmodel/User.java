package logic.logicmodel;

import dao.BookDao;
import dao.BorrowRecordDao;
import dao.FineRecordDao;
import dao.UserDao;
import daoImpl.BookDaoImpl;
import daoImpl.BorrowRecordDaoImpl;
import daoImpl.FineRecordDaoImpl;
import daoImpl.UserDaoImpl;
import factory.*;
import logic.reader.Reader;
import logic.strategypattern.Borrowable;
import logic.strategypattern.Viewable;
import logic.visitorpattern.ResourceManagement;
import logic.visitorpattern.UserVisitor;
import model.BookEntity;
import model.BorrowrecordEntity;
import model.FinerecordEntity;
import model.UserEntity;
import service.UserService;
import util.DateUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 82646 on 2019/1/23.
 * 这个包中存放的是通过组合POJO产生的逻辑对象
 * 只需要通过UserEntity来初始化即可
 * 多余的数据不返回给前端，而是统一访问者模式中的接口
 * 这个对象直接实现UserService免得逐层调用产生性能消耗
 */
public class User implements UserService {
    private UserEntity userInfo;
    private ArrayList<FinerecordEntity> fineRecords;
    private ArrayList<BorrowrecordEntity> borrowRecords;
    private Viewable viewList;   //策略模式组合查看列表
    private Borrowable borrow;   //策略模式组合借书
    private UserDao userDao = new UserDaoImpl();
    private BorrowRecordDao borrowRecordDao = new BorrowRecordDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    private FineRecordDao fineRecordDao = new FineRecordDaoImpl();
    private StrategyFactory factory;
    private UserVisitor visitor = new ResourceManagement();   //改用户的信息时通过调用这个方法实现

    //这个构造函数是后端使用访问者模式的时候使用
    public User(UserEntity userInfo) {   //只需要基础信息的时候都是null
        this.userInfo = userInfo;
        fineRecords = null;
        borrowRecords = null;

        //通过初始化工厂
        if (this.userInfo.getType().equals("Teacher")) {
            this.factory = new TeacherStrategyFactory();
        } else if (this.userInfo.getType().equals("Graduate")) {
            this.factory = new GraduateStrategyFactory();
        } else {
            this.factory = new UndergraduateStrategyFactory();
        }

        //通过抽象工厂生产策略
        this.borrow = this.factory.createBorrowable();
        this.viewList = this.factory.createViewable();
    }

    //和Administrator相同，前端通过一个id初始化
    public User(int uid) {
        this.userInfo = this.userDao.getUserInfoById(uid);
        fineRecords = null;
        borrowRecords = null;

        //通过初始化工厂
        if (this.userInfo.getType().equals("Teacher")) {
            this.factory = new TeacherStrategyFactory();
        } else if (this.userInfo.getType().equals("Graduate")) {
            this.factory = new GraduateStrategyFactory();
        } else {
            this.factory = new UndergraduateStrategyFactory();
        }

        //通过抽象工厂生产策略
        this.borrow = this.factory.createBorrowable();
        this.viewList = this.factory.createViewable();
    }

    public UserEntity getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserEntity userInfo) {
        this.userInfo = userInfo;
    }

    public ArrayList<FinerecordEntity> getFineRecords() {
        return fineRecords;
    }

    public void setFineRecords(ArrayList<FinerecordEntity> fineRecords) {
        this.fineRecords = fineRecords;
    }

    public ArrayList<BorrowrecordEntity> getBorrowRecords() {
        return borrowRecords;
    }

    public void setBorrowRecords(ArrayList<BorrowrecordEntity> borrowRecords) {
        this.borrowRecords = borrowRecords;
    }


    //调用Viewable的获得图书列表方法
    @Override
    public ArrayList<BookEntity> getBookList() {
        return this.viewList.doView();
    }

    @Override
    public int borrowBook(BookEntity book) {

        return this.borrow.doBorrow(this.getUserInfo(), book);
    }

    //还书方法主动找到用户最早借的相同的书进行归还
    @Override
    public double returnBook(BorrowrecordEntity record) {
        String returnDate = DateUtil.getNewDate(new Date());
        record.setReturndate(returnDate);

        borrowRecordDao.updateBorrowRecord(record);   //更新记录

        this.userInfo.setNowborrownum(userInfo.getNowborrownum() - 1);   //借书后当前借书-1
        userDao.updateUserInfo(this.userInfo);   //更新用户信息
        
        System.out.println("IN USER(RECORD): "+record);
        BookEntity book = bookDao.getBookById(record.getBid());

        double fineMoney = 0;
        //说明超期了
        if (returnDate.compareTo(record.getShouldreturndate()) > 0) {
            try {
                int days = DateUtil.getDays(record.getShouldreturndate(), record.getReturndate());
                FinerecordEntity fineRecord = new FinerecordEntity();
                fineRecord.setBid(record.getBid());
                fineRecord.setLatedate(days);
                fineRecord.setUid(record.getUid());
                fineRecord.setFinetotal(book.getFinerate() * fineRecord.getLatedate());
                fineMoney = fineRecord.getFinetotal();
                fineRecordDao.addFineRecord(fineRecord);   //保存罚款记录

            } catch (ParseException ex) {
                ex.printStackTrace();
            }

        }
        System.out.println("IN USER(BOOK): "+book);
        book.setRemainquantity(book.getRemainquantity() + 1);   //将书的库存+1
        bookDao.updateBookInfo(book);

        return fineMoney;
    }

    //在这个方法中创建具体的reader，然后调用show方法
    @Override
    public String readOnline(BookEntity book, String type) {

        ReaderFactory readerFactory = new ReaderFactory();
        Reader reader = readerFactory.createReader(type);
        return reader.show(book);
    }

    @Override
    public void updateUserInfo() {

        //调用visit方法
        visitor.visit(this.getUserInfo());

    }

}
