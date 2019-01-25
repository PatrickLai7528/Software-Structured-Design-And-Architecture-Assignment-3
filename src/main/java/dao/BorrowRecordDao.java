package dao;

import model.BorrowrecordEntity;

import java.util.ArrayList;

/**
 * Created by 82646 on 2019/1/24.
 * 借书记录要有归还，所以要有修改方法
 */
public interface BorrowRecordDao {

    void addBorrowRecord(BorrowrecordEntity record);

    ArrayList<BorrowrecordEntity> getBorrowRecordById(int uid);

    void updateBorrowRecord(BorrowrecordEntity record);

}
