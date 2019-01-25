package logic.strategypattern;

import dao.BookDao;
import daoImpl.BookDaoImpl;
import model.BookEntity;

import java.util.ArrayList;

/**
 * Created by 82646 on 2019/1/23.
 */
public class TeacherView implements Viewable{

    private BookDao bookDao = new BookDaoImpl();

    //老师能看到所有图书，直接返回getAllBooks
    @Override
    public ArrayList<BookEntity> doView() {

        return bookDao.getAllBooks();
    }
}
