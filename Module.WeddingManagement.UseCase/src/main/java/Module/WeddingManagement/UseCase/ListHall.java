package Module.WeddingManagement.UseCase;

import Module.WeddingManagement.ApplicationModel.Booking;
import Module.WeddingManagement.ApplicationModel.Hall;
import Module.WeddingManagement.ApplicationModel.HallType;
import Module.WeddingManagement.ApplicationModel.ShiftType;
import Module.WeddingManagement.Contract.UseCase.IListOutput;
import Module.WeddingManagement.Repository.DBContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ListHall implements IListOutput<Hall> {

    private Date weddingDate;
    private ShiftType weddingShift;
    private int tables;
    private HallType hallType;
    private BigDecimal fromPrice;
    private BigDecimal toPrice;

    public ListHall() {
    }

    public ListHall(Date weddingDate, ShiftType weddingShift) {
        this.weddingDate = weddingDate;
        this.weddingShift = weddingShift;
    }

    public ListHall(Date weddingDate, ShiftType weddingShift, int tables, HallType hallType, BigDecimal fromPrice, BigDecimal toPrice) {
        this.weddingDate = weddingDate;
        this.weddingShift = weddingShift;
        this.tables = tables;
        this.hallType = hallType;
        this.fromPrice = fromPrice;
        this.toPrice = toPrice;
    }

    @Override
    public List<Hall> GetList() {
        List<Hall> halls = DBContext.getHalls().FindAll();
        List<Hall> results = new ArrayList<>();

        if (weddingDate != null && weddingShift != null) {
            for (Hall hall : halls) {
                Set<Booking> bookings = hall.getBookings();
                for (Booking booking : bookings) {
                    if (booking.getWeddingDate() == this.weddingDate && booking.getShift() == this.weddingShift) {
                        halls.remove(hall);
                    }
                }
            }
        }

        if (tables > 0) {
            for (Hall hall : halls) {
                if (hall.getTables() < tables) {
                    halls.remove(hall);
                }
            }
        }

        BigDecimal decimal0 = new BigDecimal(0);

        //Điều kiện lọc
//        if (fromPrice.doubleValue() >= 0 && toPrice.doubleValue() >= fromPrice.doubleValue()) {
//            for (Hall hall : halls) {
//                if (hall.getPrice().doubleValue() <= toPrice.doubleValue() && hall.getPrice().doubleValue() >= fromPrice.doubleValue()) {
//                    halls.remove(hall);
//                }
//            }
//        }

        return halls;
    }

    public Date getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(Date weddingDate) {
        this.weddingDate = weddingDate;
    }

    public ShiftType getWeddingShift() {
        return weddingShift;
    }

    public void setWeddingShift(ShiftType weddingShift) {
        this.weddingShift = weddingShift;
    }

    public int getTables() {
        return tables;
    }

    public void setTables(int tables) {
        this.tables = tables;
    }

    public HallType getHallType() {
        return hallType;
    }

    public void setHallType(HallType hallType) {
        this.hallType = hallType;
    }

    public BigDecimal getFromPrice() {
        return fromPrice;
    }

    public void setFromPrice(BigDecimal fromPrice) {
        this.fromPrice = fromPrice;
    }

    public BigDecimal getToPrice() {
        return toPrice;
    }

    public void setToPrice(BigDecimal toPrice) {
        this.toPrice = toPrice;
    }
}
