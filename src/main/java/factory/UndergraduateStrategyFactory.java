package factory;

import logic.strategypattern.Borrowable;
import logic.strategypattern.UndergraduateBorrow;
import logic.strategypattern.UndergraduateView;
import logic.strategypattern.Viewable;

/**
 * Created by 82646 on 2019/1/23.
 */
public class UndergraduateStrategyFactory implements StrategyFactory{

    @Override
    public Viewable createViewable() {

        return new UndergraduateView();
    }

    @Override
    public Borrowable createBorrowable() {

        return new UndergraduateBorrow();
    }

}
