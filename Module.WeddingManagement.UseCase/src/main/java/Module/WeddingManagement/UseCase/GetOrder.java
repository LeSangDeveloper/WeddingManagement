package Module.WeddingManagement.UseCase;

import Module.WeddingManagement.ApplicationModel.Order;
import Module.WeddingManagement.Contract.UseCase.IGet;
import Module.WeddingManagement.Repository.DBContext;

public class GetOrder implements IGet<Order> {
    private int bookingId;

    public GetOrder() {

    }

    public GetOrder(int bookingId) {

    }

    @Override
    public Order Get() {
        Order order = DBContext.getOrders().Find(bookingId);
        return order;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
