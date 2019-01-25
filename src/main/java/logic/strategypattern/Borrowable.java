package logic.strategypattern;

import model.BookEntity;
import model.UserEntity;

/**
 * Created by 82646 on 2019/1/23.
 *
 */
public interface Borrowable {

    //借书方法
    int doBorrow(UserEntity user, BookEntity book);

}
