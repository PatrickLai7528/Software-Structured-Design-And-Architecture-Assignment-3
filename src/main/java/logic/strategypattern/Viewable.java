package logic.strategypattern;

import model.BookEntity;

import java.util.ArrayList;

/**
 * Created by 82646 on 2019/1/23.
 * view参数不需要传入任何user参数
 */
public interface Viewable {

    //返回图书列表
    ArrayList<BookEntity> doView();

}
