package Module.WeddingManagement.ApplicationModel;

import java.math.BigDecimal;

public class Service extends AbstractModel {

    private int id;
    private BigDecimal price;
    private String note;
    private String type;

    public Service()
    {

    }

    public Service(int id, BigDecimal price, String note, String type) {
        this.id = id;
        this.price = price;
        this.note = note;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
