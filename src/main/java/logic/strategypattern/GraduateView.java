package logic.strategypattern;

import dao.BookDao;
import daoImpl.BookDaoImpl;
import model.BookEntity;

import java.util.ArrayList;

/**
 * Created by 82646 on 2019/1/23.
 */
public class GraduateView implements Viewable{

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public ArrayList<BookEntity> doView() {

        ArrayList<BookEntity> resultList = bookDao.getBookByType("Normal");
        ArrayList<BookEntity> secondList = bookDao.getBookByType("UndergraduateForbidden");
        resultList.addAll(secondList);

        return resultList;
    }

}
