package daoImpl;

import dao.BookDao;
import model.BookEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 82646 on 2019/1/24.
 *
 */
public class BookDaoImpl implements BookDao {

    @Override
    public void updateBookInfo(BookEntity book) {
        Session session = HibernateUtil.getSession();

        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(book);
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
    public ArrayList<BookEntity> getBookByType(String type) {
        Session session = HibernateUtil.getSession();
        Query<BookEntity> query = session.createQuery("from BookEntity where type=?1");
        query.setParameter(1,type);
        List<BookEntity> bookList = query.getResultList();
        session.close();
        ArrayList<BookEntity> resultList = new ArrayList<BookEntity>();
        resultList.addAll(bookList);

        return resultList;
    }

    @Override
    public ArrayList<BookEntity> getAllBooks() {
        Session session = HibernateUtil.getSession();
        Query<BookEntity> query = session.createQuery("from BookEntity");
        List<BookEntity> bookList = query.getResultList();
        session.close();
        ArrayList<BookEntity> resultList = new ArrayList<BookEntity>();
        resultList.addAll(bookList);

        return resultList;
    }

    @Override
    public BookEntity getBookById(int bid) {
        
        return null;
    }
}
