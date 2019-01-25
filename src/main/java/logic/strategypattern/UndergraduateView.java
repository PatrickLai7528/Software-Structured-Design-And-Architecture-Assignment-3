package logic.strategypattern;

import dao.BookDao;
import daoImpl.BookDaoImpl;
import model.BookEntity;

import java.util.ArrayList;

/**
 * Created by 82646 on 2019/1/23.
 * 本科生只能看到normal类的图书
 */
public class UndergraduateView implements Viewable{

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public ArrayList<BookEntity> doView() {
        return bookDao.getBookByType("Normal");
    }

}
