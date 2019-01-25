package model;

import javax.persistence.*;

/**
 * Created by 82646 on 2019/1/23.
 */
@Entity
@Table(name = "email", schema = "librarydb")
public class EmailEntity {
    private int eid;
    private int aid;
    private String content;

    @Id
    @Column(name = "eid", nullable = false)
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    @Basic
    @Column(name = "aid", nullable = false)
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 500)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailEntity that = (EmailEntity) o;

        if (eid != that.eid) return false;
        if (aid != that.aid) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eid;
        result = 31 * result + aid;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
