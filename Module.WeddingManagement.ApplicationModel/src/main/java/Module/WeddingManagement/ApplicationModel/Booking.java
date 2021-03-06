package Module.WeddingManagement.ApplicationModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Booking extends AbstractModel {

    private int id;
    private Customer customer;
    private Employee employee;
    private Menu menu;
    private Hall hall;
    private Set<Service> services;
    private Date createdAt;
    private Date weddingDate;
    private int tables;
    private ShiftType shift;
    private String note;
    private BigDecimal price;

    public Booking() {

    }

    public Booking(Customer customer, Employee employee, Menu menu, Hall hall, Set<Service> services, Date createdAt, Date weddingDate, int tables, ShiftType shift, String note, BigDecimal price) {
        this.customer = customer;
        this.employee = employee;
        this.menu = menu;
        this.hall = hall;
        this.services = services;
        this.createdAt = createdAt;
        this.weddingDate = weddingDate;
        this.tables = tables;
        this.shift = shift;
        this.note = note;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(Date weddingDate) {
        this.weddingDate = weddingDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
