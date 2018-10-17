package com.vozup.givemetaxi;

import com.vozup.givemetaxi.entities.OrderEntity;
import com.vozup.givemetaxi.repository.OrderRepository;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class OrderChart {
    @Inject
    private OrderRepository repository;
    private List<OrderEntity> orders;

    private BarChartModel barChartModel;

    @PostConstruct
    public void init() {
        createAnimatedModel();
        //orders = repository.findAllByTimeHours(21);
    }

    private void createAnimatedModel() {
        barChartModel = initialBarModel();
        barChartModel.setTitle("Статистика заказов по времени");
        barChartModel.setAnimate(true);
        barChartModel.setLegendPosition("ne");

        Axis yAxis = barChartModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
    }

    private BarChartModel initialBarModel() {
        BarChartModel model = new BarChartModel();

        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);

        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 135);
        girls.set("2008", 120);

        model.addSeries(boys);
        model.addSeries(girls);

        return model;

    }


    public BarChartModel getBarChartModel() {
        return barChartModel;
    }
}
