package com.example.course_project.charts;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: chart line and refactoring
public class Line implements MyChart {
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();
    private final LineChart<Number, Number> lineChart;
    private final Stage stage;
    private final String legendLabel = "My portfolio";
    private boolean isLegendShown = true;

    public Line(Stage stage) {
        this.stage = stage;

        xAxis.setLabel("Number of Month");
        //creating the chart
        lineChart = new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        XYChart.Series<Number,Number> series2 = new XYChart.Series<>();
        series.setName("My portfolio");

       /* List<Integer> xs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<Integer> ys = Arrays.asList(23,14,15,24,34,36,22,45,43,17,29,25);

        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(2);
        double[] coefficients = polyfit(xs, ys, 2);

        for (double x = 1; x <= 12; x += 0.05) {
            double y = polynomial(x, coefficients);
            series2.getData().add(new XYChart.Data<>(x,y));
        }*/

        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));

        lineChart.getData().add(series);

        //adding a context menu item to the chart
        final MenuItem updateChartTitle = new MenuItem("Rename title");
        updateChartTitle.setOnAction(event -> {
            displayRenameDialog(Util.LabelToRename.TITLE);
        });

        final MenuItem updateXAxisLabel = new MenuItem("Rename X-axis title");
        updateXAxisLabel.setOnAction(event -> {
            displayRenameDialog(Util.LabelToRename.X_AXIS);
        });

        final MenuItem toggleLegend = new MenuItem("Toggle legend");
        toggleLegend.setOnAction(event -> {
            setToggleLegend(!isLegendShown);
            if(isLegendShown){
                series.setName(legendLabel);
            }
            else{
                series.setName("");
            }
        });

        final ContextMenu menu = new ContextMenu(
                updateChartTitle,
                updateXAxisLabel,
                toggleLegend
                // setTrendline
        );

        lineChart.setOnMouseClicked(event -> {
            if (MouseButton.SECONDARY.equals(event.getButton())) {
                menu.show(stage, event.getScreenX(), event.getScreenY());
            }
        });
    }

    public LineChart<Number, Number> getChart() {
        return this.lineChart;
    }

    private void displayRenameDialog(Util.LabelToRename label) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        VBox dialogVbox = new VBox(20);
        Button submitButton = new Button("Submit");
        TextField tf = new TextField(Util.getPrompt(label));
        dialogVbox.getChildren().addAll(tf, submitButton);
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();

        submitButton.setOnAction(e -> {
            switch (label) {
                case TITLE:
                    lineChart.setTitle(tf.getText());
                    break;
                case X_AXIS:
                    xAxis.setLabel(tf.getText());
                    break;
            }
            dialog.close();
        });
    }

    private void setToggleLegend(boolean value){
        this.isLegendShown = value;
    }
}
