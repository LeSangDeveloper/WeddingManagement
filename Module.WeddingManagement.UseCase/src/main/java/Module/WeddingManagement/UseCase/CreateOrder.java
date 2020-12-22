package Module.WeddingManagement.UseCase;

import Module.WeddingManagement.ApplicationModel.Booking;
import Module.WeddingManagement.ApplicationModel.Order;
import Module.WeddingManagement.Contract.UseCase.ICreate;
import Module.WeddingManagement.Repository.DBContext;

import java.math.BigDecimal;
import java.util.Date;

public class CreateOrder implements ICreate<Order> {

    private Date createAt;
    private Booking booking;
    private BigDecimal cash;

    public CreateOrder() {

    }

    public CreateOrder(Date createAt, Booking booking) {
        this.createAt = createAt;
        this.booking = booking;
    }

    public CreateOrder(Date createAt, Booking booking, BigDecimal cash) {
        this.createAt = createAt;
        this.booking = booking;
        this.cash = cash;
    }

    private boolean validate() {
       return true;
    }

    @Override
    public Order Create() {
        Date date = new Date();
        long diff = date.getTime() - booking.getWeddingDate().getTime();
        int diffDate = (int)(diff / 24 * 60 * 60 * 1000);
        if (diff > 0) {
            BigDecimal decimal = new BigDecimal(diffDate / 100);
            cash = (booking.getPrice().add(booking.getPrice().multiply(decimal)));
        }
        else {
            cash = booking.getPrice();
        }
        System.out.println("CreateOrder" + cash);
        Order entity = new Order(booking, createAt, new BigDecimal(1000));
        DBContext.getOrders().Add(entity);
        return entity;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }
}
