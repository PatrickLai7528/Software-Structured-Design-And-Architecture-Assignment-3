package factory;

import logic.strategypattern.Borrowable;
import logic.strategypattern.TeacherBorrow;
import logic.strategypattern.TeacherView;
import logic.strategypattern.Viewable;

/**
 * Created by 82646 on 2019/1/23.
 */
public class TeacherStrategyFactory implements StrategyFactory{

    @Override
    public Viewable createViewable() {

        return new TeacherView();
    }

    @Override
    public Borrowable createBorrowable() {

        return new TeacherBorrow();
    }
}
