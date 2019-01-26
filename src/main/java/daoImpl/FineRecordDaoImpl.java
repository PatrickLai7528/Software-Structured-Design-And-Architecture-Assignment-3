package daoImpl;

import dao.FineRecordDao;
import model.FinerecordEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 82646 on 2019/1/24.
 */
public class FineRecordDaoImpl implements FineRecordDao {

    @Override
    public ArrayList<FinerecordEntity> getFineRecordByUser(int uid) {
        Session session = HibernateUtil.getSession();

        Query<FinerecordEntity> query = session.createQuery("from FinerecordEntity where uid=?1");
        query.setParameter(1,uid);
        List<FinerecordEntity> records = query.getResultList();

        session.close();
        ArrayList<FinerecordEntity> resultList = new ArrayList<>();
        resultList.addAll(records);

        return resultList;
    }

    @Override
    public void addFineRecord(FinerecordEntity record) {

        Session session = HibernateUtil.getSession();

        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.persist(record);
            tx.commit();
        }catch (Exception ex){
            if(tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }
}
