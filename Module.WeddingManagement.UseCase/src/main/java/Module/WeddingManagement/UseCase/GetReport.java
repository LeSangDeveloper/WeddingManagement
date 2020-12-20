package Module.WeddingManagement.UseCase;

import Module.WeddingManagement.ApplicationModel.Order;
import Module.WeddingManagement.Contract.UseCase.IListOutput;
import Module.WeddingManagement.Repository.DBContext;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

public class GetReport implements IListOutput<Order> {

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

    private boolean isEqualWithoutTime(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        int day1 = cal1.get(Calendar.DAY_OF_MONTH);
        int month1 = cal1.get(Calendar.MONTH);
        int year1 = cal1.get(Calendar.YEAR);

        cal1.setTime(date2);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        int day2 = cal1.get(Calendar.DAY_OF_MONTH);
        int month2 = cal1.get(Calendar.MONTH);
        int year2 = cal1.get(Calendar.YEAR);

        return (day1 == day2) && (month1 == month2) && (year1 == year2);
    }

    private boolean isEqualWithoutDayTime(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance(TimeZone.getDefault());
        cal1.setTime(date1);
        cal1.set(Calendar.DAY_OF_MONTH, 0);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        cal1.setTimeZone(TimeZone.getDefault());
        int month1 = cal1.get(Calendar.MONTH);
        int year1 = cal1.get(Calendar.YEAR);

        cal1.setTime(date2);
        cal1.set(Calendar.DAY_OF_MONTH, 0);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        int month2 = cal1.get(Calendar.MONTH);
        int year2 = cal1.get(Calendar.YEAR);

        return (month1 == month2) && (year1 == year2);
    }

    @Override
    public List<Order> GetList() {
        return DBContext.getOrders().FindAll();
    }

    public List<BigDecimal> GetReportByQuater(){
        List<BigDecimal> result = new ArrayList<>();
        int minMonth = 0;
        int maxMonth = 0;
        switch (quarter) {
            case 1 :
                minMonth = 1;
                maxMonth = 3;
                break;
            case 2:
                minMonth = 4;
                maxMonth = 6;
                break;
            case 3:
                minMonth = 7;
                maxMonth = 9;
                break;
            case 4:
                minMonth = 10;
                maxMonth = 12;
                break;
            default:
                minMonth = 0;
                maxMonth = 0;
                break;
        }

        for (int i = minMonth; i <= maxMonth; ++i) {

            Date temp = new GregorianCalendar(year, i - 1, 1).getTime();
            BigDecimal total = new BigDecimal(0);

            for (Order order : orders) {
                if (isEqualWithoutTime(order.getCreatedAt(), temp)) {
                    BigDecimal test1 = order.getCash();
                    total = total.add(test1, MathContext.DECIMAL64);
                }
            }

            result.add(total);
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
            BigDecimal total = new BigDecimal(0);

            for (Order order : orders) {
                if (isEqualWithoutTime(order.getCreatedAt(), temp)) {
                    BigDecimal test1 = order.getCash();
                    total = total.add(test1, MathContext.DECIMAL64);
                }
            }

            result.add(total);

        }

        return result;
    }

    public List<BigDecimal> GetReportByYear() {
        List<BigDecimal> result = new ArrayList<>();
        int maxMonth = 12;
        for (int i = 1; i <= maxMonth; ++i) {
            Date temp = new GregorianCalendar(year, i - 1, 1).getTime();
            BigDecimal total = new BigDecimal(0);

            for (Order order : orders) {
                Date tempDate = order.getCreatedAt();
                boolean test = isEqualWithoutDayTime(temp, tempDate);
                if (test) {
                    BigDecimal test1 = order.getCash();
                    total = total.add(test1, MathContext.DECIMAL64);
                }
            }

            result.add(total);

        }

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
