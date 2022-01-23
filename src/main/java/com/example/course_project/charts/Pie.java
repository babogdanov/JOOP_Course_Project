package com.example.course_project.charts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class Pie implements MyChart {

    private final PieChart chart;
    public Pie(){
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Grapefruit", 13),
                        new PieChart.Data("Oranges", 25),
                        new PieChart.Data("Plums", 10),
                        new PieChart.Data("Pears", 22),
                        new PieChart.Data("Apples", 30));
        chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");
    }

    public PieChart getChart(){
        return this.chart;
    }
}
