package Web.Bean;


import Module.WeddingManagement.ApplicationModel.Order;
import Module.WeddingManagement.UseCase.GetReport;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
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

        List<BigDecimal> listData = (new GetReport(4,1,2020)).GetReportByMonth();
        List<Number> numberData = new ArrayList<>();
        for(BigDecimal big : listData)
        {
            numberData.add(big.toBigInteger());
            //System.out.println(big);
        }
        //System.out.println(numberData.size());
        dataSet.setData(numberData);
        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        List<String> color = new ArrayList<>();
        for(int i = 1; i <= numberData.size(); i++){
            labels.add("ngày "+i);
            color.add("rgba(156, 39, 176,1)");
        }
//        for(int i = 1; i <= numberData.size(); i++){
//            labels.add("Tháng "+i);
//        }

        dataSet.setBackgroundColor(color);

        BarChartOptions options = new BarChartOptions();

        Title title = new Title();
        title.setDisplay(true);
        title.setText("Thống kê doanh thu tháng 1 - 2020");
        options.setTitle(title);

        data.setLabels(labels);
        barModel.setData(data);
        barModel.setOptions(options);
    }

    public BarChartModel getBarModel() {
        return barModel;
    }
}
