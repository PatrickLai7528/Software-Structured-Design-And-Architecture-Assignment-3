package model;

import javax.persistence.*;

/**
 * Created by 82646 on 2019/1/23.
 */
@Entity
@Table(name = "finerecord", schema = "librarydb")
public class FinerecordEntity {
    private int fid;
    private int uid;
    private int bid;
    private int latedate;
    private double finetotal;

    @Id
    @Column(name = "fid", nullable = false)
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
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
    @Column(name = "latedate", nullable = false)
    public int getLatedate() {
        return latedate;
    }

    public void setLatedate(int latedate) {
        this.latedate = latedate;
    }

    @Basic
    @Column(name = "finetotal", nullable = false, precision = 0)
    public double getFinetotal() {
        return finetotal;
    }

    public void setFinetotal(double finetotal) {
        this.finetotal = finetotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FinerecordEntity that = (FinerecordEntity) o;

        if (fid != that.fid) return false;
        if (uid != that.uid) return false;
        if (bid != that.bid) return false;
        if (latedate != that.latedate) return false;
        if (Double.compare(that.finetotal, finetotal) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = fid;
        result = 31 * result + uid;
        result = 31 * result + bid;
        result = 31 * result + latedate;
        temp = Double.doubleToLongBits(finetotal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
