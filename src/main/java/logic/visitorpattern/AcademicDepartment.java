package logic.visitorpattern;

import dao.BorrowRecordDao;
import daoImpl.BorrowRecordDaoImpl;
import logic.logicmodel.User;
import model.BorrowrecordEntity;
import model.UserEntity;

import java.util.ArrayList;

/**
 * Created by 82646 on 2019/1/23.
 * 负责查看借阅记录
 */
public class AcademicDepartment implements UserVisitor{

    private BorrowRecordDao borrowRecordDao = new BorrowRecordDaoImpl();

    @Override
    public User visit(UserEntity userInfo) {
        ArrayList<BorrowrecordEntity> records = borrowRecordDao.getBorrowRecordById(userInfo.getUserid());
        User user = new User(userInfo);
        user.setBorrowRecords(records);
        return user;
    }
}
