package com.example.course_project;

import com.example.course_project.charts.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    private final Stage stage = HelloApplication.getStage();

    @FXML
    private Label welcomeText = new Label("Welcome to this charting application!");

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to this charting application!");
    }

    @FXML
    public void onPieChartButtonClick(ActionEvent actionEvent) throws IOException {
        PieChart pie = new Pie().getChart();
        displayChart(pie);
    }

    @FXML
    public void onLineChartButtonClick(ActionEvent actionEvent) throws IOException {
        LineChart line = new Line().getChart();
        displayChart(line);
    }

    @FXML
    public void onAreaChartButtonClick() throws IOException {
        AreaChart area = new Area().getChart();
        displayChart(area);
    }
    @FXML
    public void onBarChartButtonClick() throws IOException {
        BarChart bar = new Bar().getChart();
        displayChart(bar);
    }

    @FXML
    public void onBubbleChartButtonClick() throws IOException {
        BubbleChart bubble = new Bubble().getChart();
        displayChart(bubble);
    }

    @FXML
    public void onScatterChartButtonClick() throws IOException {
        ScatterChart scatter = new Scatter().getChart();
        displayChart(scatter);
    }

    private void displayChart(Chart chart) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("base-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        ((VBox) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
    }



}