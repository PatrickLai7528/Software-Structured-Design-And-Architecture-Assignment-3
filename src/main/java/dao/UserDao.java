package dao;

import model.UserEntity;

/**
 * Created by 82646 on 2019/1/24.
 *
 */
public interface UserDao {
    void updateUserInfo(UserEntity userInfo);

    UserEntity getUserInfoById(int uid);

}
