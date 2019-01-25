package dao;

import model.FinerecordEntity;

import java.util.ArrayList;

/**
 * Created by 82646 on 2019/1/24.
 */
public interface FineRecordDao {

    ArrayList<FinerecordEntity> getFineRecordByUser(int uid);

    void addFineRecord(FinerecordEntity record);

}
