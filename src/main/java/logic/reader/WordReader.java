package logic.reader;

import model.BookEntity;

/**
 * Created by 82646 on 2019/1/23.
 */
public class WordReader implements Reader{

    @Override
    public String show(BookEntity book) {

        return "您正在使用Word阅读器查看" + book.getBname() + ",它的描述是：" + book.getDescription();
    }
}
