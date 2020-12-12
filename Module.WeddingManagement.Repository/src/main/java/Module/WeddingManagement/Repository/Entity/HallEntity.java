package Module.WeddingManagement.Repository.Entity;

import Module.WeddingManagement.ApplicationModel.Hall;
import Module.WeddingManagement.ApplicationModel.HallType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hall")
public class HallEntity implements Serializable {
    public static final String QUERY_FIND_ALL_HALLS = "HallEntity.FindAll";
    public static final String QUERY_FIND_BY_ID = "HallEntity.FindById";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    private String name;
    @Basic
    private double price;
    @Basic
    private HallType type;
    @Basic
    private String note;

    public int getHallId() {
        return id;
    }

    public void setHallId(int hallId) {
        id = hallId;
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

    public HallType getType() {
        return type;
    }

    public void setType(HallType type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
