package dao;

import model.BookEntity;

import java.util.ArrayList;

/**
 * Created by 82646 on 2019/1/24.
 */
public interface BookDao {

    void updateBookInfo(BookEntity book);

    ArrayList<BookEntity> getBookByType(String type);

    //这个是管理员调用的方法
    ArrayList<BookEntity> getAllBooks();

    //还是需要一个通过id查找书的方法
    BookEntity getBookById(int bid);
}
