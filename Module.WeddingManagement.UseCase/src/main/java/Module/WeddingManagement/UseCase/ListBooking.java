package Module.WeddingManagement.UseCase;

import Module.WeddingManagement.ApplicationModel.Booking;
import Module.WeddingManagement.ApplicationModel.ShiftType;
import Module.WeddingManagement.Contract.UseCase.IListOuput;
import Module.WeddingManagement.Repository.DBContext;

import java.util.Date;
import java.util.List;

public class ListBooking implements IListOuput<Booking> {

    private Date weddingDate;
    private ShiftType shift;

    public ListBooking() {

    }

    public ListBooking(Date weddingDate, ShiftType shift) {
        this.weddingDate = weddingDate;
        this.shift = shift;
    }

    @Override
    public List<Booking> GetList() {
        List<Booking> bookings = DBContext.getBookings().FindAll();
        if (weddingDate != null) {
            for (Booking booking : bookings) {
                if (booking.getWeddingDate() == weddingDate) {
                    bookings.remove(booking);
                }
            }
        }

        if (shift != null) {
            for (Booking booking : bookings) {
                if (booking.getShift() == shift) {
                    bookings.remove(booking);
                }
            }
        }

        return bookings;
    }

    public Date getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(Date weddingDate) {
        this.weddingDate = weddingDate;
    }

    public ShiftType getShift() {
        return shift;
    }

    public void setShift(ShiftType shift) {
        this.shift = shift;
    }
}
