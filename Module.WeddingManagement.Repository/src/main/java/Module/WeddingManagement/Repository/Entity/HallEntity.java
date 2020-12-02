package Module.WeddingManagement.Repository.Entity;

import Module.WeddingManagement.ApplicationModel.Hall;

import javax.persistence.*;

@Entity
@Table(name = "Halls")
@NamedQueries({
        @NamedQuery(name = HallEntity.QUERY_FIND_ALL_HALLS, query = "SELECT i from HallEntity i where i.hallId = :hallId"),
        @NamedQuery(name = HallEntity.QUERY_FIND_BY_ID, query =  "SELECT i from HallEntity i")
})
public class HallEntity {
    public static final String QUERY_FIND_ALL_HALLS = "HallEntity.FindAll";
    public static final String QUERY_FIND_BY_ID = "HallEntity.FindById";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long HallId;

    @Basic
    private String name;
    @Basic
    private double price;
    @Basic
    private Hall.HallType type;
    @Basic
    private String note;

    public long getHallId() {
        return HallId;
    }

    public void setHallId(long hallId) {
        HallId = hallId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Hall.HallType getType() {
        return type;
    }

    public void setType(Hall.HallType type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
