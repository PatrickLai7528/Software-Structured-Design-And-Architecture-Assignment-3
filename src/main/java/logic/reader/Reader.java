package logic.reader;

import model.BookEntity;

/**
 * Created by 82646 on 2019/1/23.
 * 抽象的阅读类
 */
public interface Reader {

    String show(BookEntity book);

}
