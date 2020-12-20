package Web.Bean;

import Module.WeddingManagement.ApplicationModel.Booking;
import Module.WeddingManagement.UseCase.ListBooking;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.util.List;

@ManagedBean
@RequestScoped
public class BookingBean{
    private ListBooking bookingList;

    public BookingBean(){
        bookingList = new ListBooking();
        System.out.println("BookingBean đc gọi " + bookingList);
    }

    public ListBooking getBookingList() {
        return bookingList;
    }

    public void setBookingList(ListBooking bookingList) {
        this.bookingList = bookingList;
    }

    public String getResponse() {
        return "abcxyz";
    }

}
