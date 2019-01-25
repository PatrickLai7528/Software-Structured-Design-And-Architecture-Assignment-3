package logic.visitorpattern;

import dao.AdminDao;
import dao.UserDao;
import daoImpl.AdminDaoImpl;
import daoImpl.UserDaoImpl;
import logic.logicmodel.User;
import model.AdministratorEntity;
import model.UserEntity;

import java.util.ArrayList;

/**
 * Created by 82646 on 2019/1/23.
 * 这个类负责修改学生的信息
 */
public class ResourceManagement implements UserVisitor {

    private ArrayList<AdministratorEntity> admins;   //拥有管理员列表
    private AdminDao adminDao = new AdminDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    public ResourceManagement() {
        //暂时只有一个管理员
        AdministratorEntity admin = adminDao.getAdminById(1);
        admins = new ArrayList<AdministratorEntity>();
        admins.add(admin);
    }

    @Override
    public User visit(UserEntity userInfo) {
        userDao.updateUserInfo(userInfo);

        //观察者模式进行通知
        for(AdministratorEntity admin:admins){
            admin.update(userInfo);
        }

        //这个方法只是修改用户的信息，返回null就好了
        return null;
    }
}
