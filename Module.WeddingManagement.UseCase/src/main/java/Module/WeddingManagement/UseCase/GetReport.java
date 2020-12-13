package Module.WeddingManagement.UseCase;

import Module.WeddingManagement.ApplicationModel.Order;
import Module.WeddingManagement.Contract.UseCase.IListOuput;
import Module.WeddingManagement.Repository.DBContext;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class GetReport implements IListOuput<Order> {

    private List<Order> orders;
    private int quarter;
    private int month;
    private int year;

    public GetReport() {
        orders = DBContext.getOrders().FindAll();
    }

    public GetReport(int quarter, int month, int year) {
        orders = DBContext.getOrders().FindAll();
        this.quarter = quarter;
        this.month = month;
        this.year = year;
    }

    @Override
    public List<Order> GetList() {
        return DBContext.getOrders().FindAll();
    }

    public List<BigDecimal> GetReportByQuater(){
        List<BigDecimal> result = new ArrayList<>();

        for (Order order : orders) {

        }

        return result;
    }

    public List<BigDecimal> GetReportByMonth() {
        List<BigDecimal> result = new ArrayList<>();
        int maxDate = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            maxDate = 31;
        else if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDate = 30;
        } else if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            maxDate = 29;
        }
        else {
            maxDate = 28;
        }
        for (int i = 1; i <= maxDate; ++i) {
            Date temp = new GregorianCalendar(year, month - 1, i).getTime();

            for (Order order : orders) {

            }
        }

        return result;
    }

    public List<BigDecimal> GetReportByYear() {
        List<BigDecimal> result = new ArrayList<>();

        return result;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
