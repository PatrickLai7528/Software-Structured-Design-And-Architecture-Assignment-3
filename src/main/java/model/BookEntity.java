package model;

import javax.persistence.*;

/**
 * Created by 82646 on 2019/1/23.
 */
@Entity
@Table(name = "book", schema = "librarydb")
public class BookEntity {
    private int bid;
    private String bname;
    private String description;
    private int quantity;
    private int remainquantity;
    private double finerate;
    private String type;

    @Id
    @Column(name = "bid", nullable = false)
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    @Basic
    @Column(name = "bname", nullable = false, length = 255)
    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "remainquantity", nullable = false)
    public int getRemainquantity() {
        return remainquantity;
    }

    public void setRemainquantity(int remainquantity) {
        this.remainquantity = remainquantity;
    }

    @Basic
    @Column(name = "finerate", nullable = false, precision = 0)
    public double getFinerate() {
        return finerate;
    }

    public void setFinerate(double finerate) {
        this.finerate = finerate;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (bid != that.bid) return false;
        if (quantity != that.quantity) return false;
        if (remainquantity != that.remainquantity) return false;
        if (Double.compare(that.finerate, finerate) != 0) return false;
        if (bname != null ? !bname.equals(that.bname) : that.bname != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = bid;
        result = 31 * result + (bname != null ? bname.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + remainquantity;
        temp = Double.doubleToLongBits(finerate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", remainquantity=" + remainquantity +
                ", finerate=" + finerate +
                ", type='" + type + '\'' +
                '}';
    }
}
