package Web.Bean;

import Module.WeddingManagement.ApplicationModel.Booking;
import Module.WeddingManagement.ApplicationModel.Menu;
import Module.WeddingManagement.UseCase.ListBooking;

import java.awt.print.Book;
import java.util.Date;

public class TestCallData {

    public static void main(String[] args) {
        System.out.println("vo create booking");
        CreateBookingBean createBookingBean = new CreateBookingBean();
        Booking booking = new Booking();
        booking.setMenu(new Menu());
        booking.setCreatedAt(new Date());
        createBookingBean.addBooking();
    }
}
