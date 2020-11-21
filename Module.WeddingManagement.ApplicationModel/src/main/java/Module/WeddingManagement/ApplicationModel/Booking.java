package Module.WeddingManagement.ApplicationModel;

import java.util.Date;

public class Booking extends AbstractModel {
    private int bookingId;
    private int hallId;
    private int menuId;
    private int employeeId;
    private int customerId;
    private Date createdAt;
    private Date dateOfPayment;
    private int tables;
    private ShiftType shift;
    private String note;
    private double price;

    public enum ShiftType
    {
        Morning,
        Afternoon,
        Evening
    }

}
