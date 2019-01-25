package model;

import logic.logicmodel.User;
import logic.visitorpattern.AcademicDepartment;
import logic.visitorpattern.FinanceDepartment;
import logic.visitorpattern.ResourceManagement;

import javax.persistence.*;

/**
 * Created by 82646 on 2019/1/23.
 */
@Entity
@Table(name = "user", schema = "librarydb")
public class UserEntity {
    private int userid;
    private String name;
    private String type;
    private String department;
    private String sex;
    private int maxborrownum;
    private int nowborrownum;

    @Id
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "department", nullable = false, length = 255)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "sex", nullable = false, length = 255)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "maxborrownum", nullable = false)
    public int getMaxborrownum() {
        return maxborrownum;
    }

    public void setMaxborrownum(int maxborrownum) {
        this.maxborrownum = maxborrownum;
    }

    @Basic
    @Column(name = "nowborrownum", nullable = false)
    public int getNowborrownum() {
        return nowborrownum;
    }

    public void setNowborrownum(int nowborrownum) {
        this.nowborrownum = nowborrownum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userid != that.userid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (nowborrownum != that.nowborrownum) return false;
        if(maxborrownum != that.maxborrownum) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + maxborrownum;
        result = 31 * result + nowborrownum;
        return result;
    }

    //访问者模式的accept
    public User accept(FinanceDepartment financeDepartment){
        return financeDepartment.visit(this);
    }

    public User accept(AcademicDepartment academicDepartment){
        return academicDepartment.visit(this);
    }

    public User accept(ResourceManagement resourceManagement){
        return resourceManagement.visit(this);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", department='" + department + '\'' +
                ", sex='" + sex + '\'' +
                ", maxborrownum=" + maxborrownum +
                ", nowborrownum=" + nowborrownum +
                '}';
    }
}
