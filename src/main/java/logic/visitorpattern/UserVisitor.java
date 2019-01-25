package logic.visitorpattern;

import logic.logicmodel.User;
import model.UserEntity;

/**
 * Created by 82646 on 2019/1/23.
 * 这个抽象接口定义了对用户进行访问的方法
 */
public interface UserVisitor {

    //传入User的信息，返回一个在某一方面更全面的User逻辑对象
    User visit(UserEntity userInfo);
}
