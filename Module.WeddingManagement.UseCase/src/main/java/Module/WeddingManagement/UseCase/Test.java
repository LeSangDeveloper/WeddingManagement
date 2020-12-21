package Module.WeddingManagement.UseCase;

import Module.WeddingManagement.ApplicationModel.Booking;
import Module.WeddingManagement.ApplicationModel.Food;
import Module.WeddingManagement.ApplicationModel.Hall;
import Module.WeddingManagement.ApplicationModel.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ListBooking listBooking = new ListBooking();
        List<Booking> bookings = listBooking.GetList();
        System.out.println(bookings);

        ListFood foods = new ListFood();
        for (Food i : foods.GetList()) {
            System.out.println(i);
        }

        ListService services = new ListService();
        for (Service service : services.GetList()) {
            System.out.println(service);
        }

        ListHall halls = new ListHall();
        for(Hall hall : halls.GetList()){
            System.out.println(hall);
        }

        GetReport getReport = new GetReport();
        getReport.setMonth(2);
        getReport.setYear(2012);
        getReport.setQuarter(2);
        List<BigDecimal> cashes = getReport.GetReportByQuater();
        System.out.println(cashes);

    }

    public static boolean isEqualWithoutTimeTest(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);

        return !(cal1.before(cal2) || cal1.after(cal2));
    }

}
