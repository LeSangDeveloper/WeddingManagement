package Module.WeddingManagement.ApplicationModel;

public class BookingService extends  AbstractModel {
    private int bookingId;
    private int serviceId;

    public BookingService(int bookingId, int serviceId) {
        this.bookingId = bookingId;
        this.serviceId = serviceId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}
