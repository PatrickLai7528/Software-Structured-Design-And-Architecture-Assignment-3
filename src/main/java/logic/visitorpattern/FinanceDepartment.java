package logic.visitorpattern;

import dao.FineRecordDao;
import daoImpl.FineRecordDaoImpl;
import logic.logicmodel.User;
import model.FinerecordEntity;
import model.UserEntity;

import java.util.ArrayList;

/**
 * Created by 82646 on 2019/1/23.
 * 代表对用户的欠费报告的查看
 */
public class FinanceDepartment implements UserVisitor{

    private FineRecordDao fineRecordDao = new FineRecordDaoImpl();

    @Override
    public User visit(UserEntity userInfo) {
        ArrayList<FinerecordEntity> records = fineRecordDao.getFineRecordByUser(userInfo.getUserid());
        User user = new User(userInfo);
        user.setFineRecords(records);

        return user;
    }
}
