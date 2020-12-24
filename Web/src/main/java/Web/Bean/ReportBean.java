package Web.Bean;


import Module.WeddingManagement.ApplicationModel.Order;
import Module.WeddingManagement.UseCase.GetReport;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.optionconfig.title.Title;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class ReportBean {
    private BarChartModel barModel;

    @PostConstruct
    public void init(){
        barModel = new BarChartModel();
        ChartData data = new ChartData();
        BarChartDataSet dataSet = new BarChartDataSet();
        dataSet.setLabel("Tổng thanh toán");

        List<BigDecimal> listData = (new GetReport(4,1,2012)).GetReportByMonth();
        List<Number> numberData = new ArrayList<Number>();
        for(BigDecimal big : listData)
        {
            numberData.add(big.toBigInteger());
            //System.out.println(big);
        }
        //System.out.println(numberData.size());
        dataSet.setData(numberData);
        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        for(int i = 1; i <= numberData.size(); i++){
            labels.add("ngày "+i);
        }
        for(int i = 1; i <= numberData.size(); i++){
            labels.add("Tháng "+i);
        }

        Title title = new Title();
        title.setDisplay(true);
        title.setText("Thống kê doanh thu");

        data.setLabels(labels);
        barModel.setData(data);
    }

    public BarChartModel getBarModel() {
        return barModel;
    }
}
