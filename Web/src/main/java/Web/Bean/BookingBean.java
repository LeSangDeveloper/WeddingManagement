package Web.Bean;

import Module.WeddingManagement.ApplicationModel.Booking;
import Module.WeddingManagement.ApplicationModel.Order;
import Module.WeddingManagement.UseCase.CreateOrder;
import Module.WeddingManagement.UseCase.ListBooking;
import Module.WeddingManagement.UseCase.ListOrder;
import com.sun.istack.Nullable;
import net.bootsfaces.C;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class BookingBean{
    private List<Booking> bookingList;
    private List<Order> listOrder;

    public boolean checkBool() {
        return true;
    }

    public Boolean getTemp() {
        return temp = true;
    }

    public void setTemp(Boolean temp) {
        this.temp = temp;
    }

    private Boolean temp = true;

    public String createOrder(Booking booking) throws Exception{
        System.out.println("create Order"+booking.getId());
        CreateOrder order = new CreateOrder(new Date(),booking);
        if(order.Create()!=null){
            return "booking";
        }
        throw new Exception("Lỗi");
    }

    public BookingBean(){
        bookingList = (new ListBooking()).GetList();
        listOrder = (new ListOrder()).GetList();
        //System.out.println("BookingBean đc gọi " + bookingList +"\n" + listOrder);
    }

    public Booking checkBooking(Booking booking){
        for(Order order : listOrder){
            if(order.getId() == booking.getId()) {
                //System.out.println("Đã thanh toán");
                return booking;
            }
        }
        //System.out.println("Chưa thanh toán");
        return null;
    }

    public void remove(Booking booking){

    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public String getResponse() {
        return "abcxyz";
    }

}
