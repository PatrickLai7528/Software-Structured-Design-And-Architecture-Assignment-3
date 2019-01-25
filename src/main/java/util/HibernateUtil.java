package util;

import logic.logicmodel.Administrator;
import logic.logicmodel.User;
import model.BookEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

/**
 * Created by 82646 on 2019/1/23.
 */
public class HibernateUtil {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    //在这个类里面写测试好了
//    public static void main(final String[] args) throws Exception {
////        User user1 = new User(1);
////        ArrayList<BookEntity> books = user1.getBookList();
////        int i = user1.borrowBook(books.get(0));
//
//          User user1 = new User(1);
////        Administrator administrator = new Administrator(1);
////        ArrayList<BorrowrecordEntity> records = administrator.getUserBorrowRecord(user1.getUserInfo());
////        double money = user1.returnBook(records.get(0));
////        System.out.print(money);
//
//        ArrayList<BookEntity> books = user1.getBookList();
//        System.out.print(user1.readOnline(books.get(1),"Word"));
//
////        User user2 = new User(2);
////        ArrayList<BookEntity> book2 = user2.getBookList();
//
////        user1.borrowBook(books.get(1));
////        user1.borrowBook(books.get(2))
//
//        Administrator administrator = new Administrator(1);
////        ArrayList<BorrowrecordEntity> records = administrator.getUserBorrowRecord(user1.getUserInfo());
////        double money = user1.returnBook(records.get(1));
////        UserEntity userEntity = user1.getUserInfo();
////        userEntity.setName("膨胀的张三");
////        user1.updateUserInfo();
//
////        ArrayList<FinerecordEntity> records = administrator.getUserFineRecord(user1.getUserInfo());
//
//        User user2 = new User(2);
//        ArrayList<BookEntity> bookEntities = user2.getBookList();
//        BookEntity bookEntity = bookEntities.get(0);
//        bookEntity.setDescription("");
//        administrator.EditBookInfo(bookEntity);
//    }
}
