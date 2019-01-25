package daoImpl;

import dao.AdminDao;
import model.AdministratorEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by 82646 on 2019/1/24.
 *
 */
public class AdminDaoImpl implements AdminDao {

    @Override
    public AdministratorEntity getAdminById(int aid) {

        Session session = HibernateUtil.getSession();
        Query<AdministratorEntity> query = session.createQuery("from AdministratorEntity where aid=?1");
        query.setParameter(1,aid);
        List<AdministratorEntity> list = query.getResultList();
        AdministratorEntity result = null;
        if(!list.isEmpty()){
            result = list.get(0);
        }

        session.close();
        return result;
    }
}
