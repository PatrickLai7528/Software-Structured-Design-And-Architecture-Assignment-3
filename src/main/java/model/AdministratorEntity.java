package model;

import dao.EmailDao;
import daoImpl.EmailDaoImpl;

import javax.persistence.*;

/**
 * Created by 82646 on 2019/1/23.
 */
@Entity
@Table(name = "administrator", schema = "librarydb")
public class AdministratorEntity {
    private int aid;
    private String aname;
    private EmailDao emailDao = new EmailDaoImpl();

    @Id
    @Column(name = "aid", nullable = false)
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "aname", nullable = false, length = 255)
    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdministratorEntity that = (AdministratorEntity) o;

        if (aid != that.aid) return false;
        if (aname != null ? !aname.equals(that.aname) : that.aname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid;
        result = 31 * result + (aname != null ? aname.hashCode() : 0);
        return result;
    }

    public void update(UserEntity user){
        EmailEntity email = new EmailEntity();
        email.setAid(this.getAid());
        String content = "用户" + user.getName() + ",编号" + user.getUserid() + ",刚刚修改了它的个人信息，请速去查看";
        email.setContent(content);

        emailDao.addNewEmail(email);  //保存email
    }
}
