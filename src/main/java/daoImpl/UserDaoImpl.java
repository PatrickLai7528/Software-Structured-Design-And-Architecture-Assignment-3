package daoImpl;

import dao.UserDao;
import model.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by 82646 on 2019/1/24.
 */
public class UserDaoImpl implements UserDao{

    @Override
    public void updateUserInfo(UserEntity userInfo) {
        Session session = HibernateUtil.getSession();

        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(userInfo);
            tx.commit();
        }catch (Exception ex){
            if(tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }finally {
            session.close();
        }

    }

    @Override
    public UserEntity getUserInfoById(int uid) {
        Session session = HibernateUtil.getSession();

        Query<UserEntity> query = session.createQuery("from UserEntity where userid=?1");
        query.setParameter(1,uid);
        List<UserEntity> userInfo = query.getResultList();

        UserEntity user = null;
        if(!userInfo.isEmpty()){
            user = userInfo.get(0);
        }

        return user;
    }
}
