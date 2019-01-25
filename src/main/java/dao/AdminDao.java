package dao;

import model.AdministratorEntity;

/**
 * Created by 82646 on 2019/1/24.
 */
public interface AdminDao {

    AdministratorEntity getAdminById(int aid);

}
