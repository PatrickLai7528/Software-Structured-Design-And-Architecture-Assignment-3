package factory;

import logic.strategypattern.Borrowable;
import logic.strategypattern.GraduateBorrow;
import logic.strategypattern.GraduateView;
import logic.strategypattern.Viewable;

/**
 * Created by 82646 on 2019/1/23.
 */
public class GraduateStrategyFactory implements StrategyFactory{

    @Override
    public Viewable createViewable() {
        return new GraduateView();
    }

    @Override
    public Borrowable createBorrowable() {

        return new GraduateBorrow();
    }
}
