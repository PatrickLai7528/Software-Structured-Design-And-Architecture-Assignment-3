package daoImpl;

import dao.EmailDao;
import model.BorrowrecordEntity;
import model.EmailEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 82646 on 2019/1/24.
 */
public class EmailDaoImpl implements EmailDao {

    @Override
    public void addNewEmail(EmailEntity email) {
        Session session = HibernateUtil.getSession();

        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.persist(email);
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
    public ArrayList<EmailEntity> getAdminEmails(int aid) {
        Session session = HibernateUtil.getSession();

        Query<EmailEntity> query = session.createQuery("from EmailEntity where aid=?1");
        query.setParameter(1,aid);
        List<EmailEntity> emails = query.getResultList();

        session.close();
        ArrayList<EmailEntity> resultList = new ArrayList<EmailEntity>();
        resultList.addAll(emails);

        return resultList;
    }
}
