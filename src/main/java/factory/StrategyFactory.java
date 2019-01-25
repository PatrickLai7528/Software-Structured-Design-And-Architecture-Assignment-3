package factory;

import logic.strategypattern.Borrowable;
import logic.strategypattern.Viewable;

/**
 * Created by 82646 on 2019/1/23.
 * 应用抽象工厂模式，同时生产Viewable和Borrowable
 */
public interface StrategyFactory {

    Viewable createViewable();

    Borrowable createBorrowable();
}
