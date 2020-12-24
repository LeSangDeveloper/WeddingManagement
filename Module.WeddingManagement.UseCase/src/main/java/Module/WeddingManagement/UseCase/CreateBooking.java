package Module.WeddingManagement.UseCase;

import Module.WeddingManagement.ApplicationModel.*;
import Module.WeddingManagement.Contract.UseCase.ICreate;
import Module.WeddingManagement.Repository.DBContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class CreateBooking implements ICreate<Booking> {

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

    public CreateBooking(Booking entity) {
        this.customer = entity.getCustomer();
        this.employee = entity.getEmployee();
        this.menu = entity.getMenu();
        this.hall = entity.getHall();
        this.services = entity.getServices();
        this.createdAt = entity.getCreatedAt();
        this.weddingDate = entity.getWeddingDate();
        this.tables = entity.getTables();
        this.shift = entity.getShift();
        this.note = entity.getNote();
        this.price = entity.getPrice();
    }

    public CreateBooking(Customer customer, Employee employee, Menu menu, Hall hall, Set<Service> services, Date createdAt, Date weddingDate, int tables, ShiftType shift, String note, BigDecimal price) {
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

    private boolean validate() {
        List<Booking> bookings = DBContext.getBookings().FindAll();
        for (Booking booking : bookings) {
            if (booking.getWeddingDate() == this.weddingDate && booking.getShift() == this.shift && booking.getHall() == this.hall) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Booking Create() {
        if (true) {
            System.out.println("Test create");
            Booking entity = new Booking(this.customer, this.employee, this.menu, this.hall, this.services, this.createdAt, this.weddingDate, this.tables, this.shift, this.note, this.price);
            DBContext.getBookings().Add(entity);
            return entity;
        }
        return null;
    }
}
