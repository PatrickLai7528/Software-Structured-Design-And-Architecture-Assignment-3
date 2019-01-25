package daoImpl;

import dao.BorrowRecordDao;
import model.BorrowrecordEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 82646 on 2019/1/24.
 */
public class BorrowRecordDaoImpl implements BorrowRecordDao {

    @Override
    public void addBorrowRecord(BorrowrecordEntity record) {
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

    @Override
    public ArrayList<BorrowrecordEntity> getBorrowRecordById(int uid) {
        Session session = HibernateUtil.getSession();

        Query<BorrowrecordEntity> query = session.createQuery("from BorrowrecordEntity where uid=?1");
        query.setParameter(1,uid);
        List<BorrowrecordEntity> recordList = query.getResultList();
        session.close();
        ArrayList<BorrowrecordEntity> resultList = new ArrayList<BorrowrecordEntity>();
        resultList.addAll(recordList);

        return resultList;
    }

    @Override
    public void updateBorrowRecord(BorrowrecordEntity record) {
        Session session = HibernateUtil.getSession();

        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(record);
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
