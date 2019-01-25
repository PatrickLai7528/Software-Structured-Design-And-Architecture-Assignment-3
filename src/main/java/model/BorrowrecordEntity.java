package model;

import javax.persistence.*;

/**
 * Created by 82646 on 2019/1/23.
 */
@Entity
@Table(name = "borrowrecord", schema = "librarydb")
public class BorrowrecordEntity {
    private int rid;
    private int uid;
    private int bid;
    private String borrowdate;
    private String shouldreturndate;
    private String returndate;

    @Id
    @Column(name = "rid", nullable = false)
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "uid", nullable = false)
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "bid", nullable = false)
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    @Basic
    @Column(name = "borrowdate", nullable = false)
    public String getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(String borrowdate) {
        this.borrowdate = borrowdate;
    }

    @Basic
    @Column(name = "shouldreturndate", nullable = false)
    public String getShouldreturndate() {
        return shouldreturndate;
    }

    public void setShouldreturndate(String shouldreturndate) {
        this.shouldreturndate = shouldreturndate;
    }

    @Basic
    @Column(name = "returndate")
    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BorrowrecordEntity that = (BorrowrecordEntity) o;

        if (rid != that.rid) return false;
        if (uid != that.uid) return false;
        if (bid != that.bid) return false;
        if (borrowdate != null ? !borrowdate.equals(that.borrowdate) : that.borrowdate != null) return false;
        if (shouldreturndate != null ? !shouldreturndate.equals(that.shouldreturndate) : that.shouldreturndate != null)
            return false;
        if (returndate != null ? !returndate.equals(that.returndate) : that.returndate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + uid;
        result = 31 * result + bid;
        result = 31 * result + (borrowdate != null ? borrowdate.hashCode() : 0);
        result = 31 * result + (shouldreturndate != null ? shouldreturndate.hashCode() : 0);
        result = 31 * result + (returndate != null ? returndate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BorrowrecordEntity{" +
                "rid=" + rid +
                ", uid=" + uid +
                ", bid=" + bid +
                ", borrowdate='" + borrowdate + '\'' +
                ", shouldreturndate='" + shouldreturndate + '\'' +
                ", returndate='" + returndate + '\'' +
                '}';
    }
}
