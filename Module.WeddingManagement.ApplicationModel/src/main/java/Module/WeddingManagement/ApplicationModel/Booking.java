package Module.WeddingManagement.ApplicationModel;

import java.util.Date;

public class Booking extends AbstractModel {

    private Date createdAt;
    private Date dateOfPayment;
    private int tables;
    private ShiftType shift;
    private String note;
    private double price;

    public Booking(Date createdAt, Date dateOfPayment, int tables, ShiftType shift, String note, double price) {
        this.createdAt = createdAt;
        this.dateOfPayment = dateOfPayment;
        this.tables = tables;
        this.shift = shift;
        this.note = note;
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public int getTables() {
        return tables;
    }

    public void setTables(int tables) {
        this.tables = tables;
    }

    public ShiftType getShift() {
        return shift;
    }

    public void setShift(ShiftType shift) {
        this.shift = shift;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public enum ShiftType
    {
        Morning,
        Afternoon,
        Evening
    }

}
