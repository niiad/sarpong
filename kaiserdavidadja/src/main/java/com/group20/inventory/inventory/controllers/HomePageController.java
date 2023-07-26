package com.group20.inventory.inventory.controllers;

import com.group20.inventory.inventory.models.IssuedProduct;
import com.group20.inventory.inventory.models.Product;
import com.group20.inventory.inventory.models.Vendor;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    public AnchorPane chartContainer;
    public Text productCountLabel;
    public Text vendorCountLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Vendors");
        //creating the chart
        final LineChart<Number, Number> lineChart =
                new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Vendor Transaction Volume");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Volume");
        //populating the series with data
        List<IssuedProduct> issuedProducts = IssuedProduct.selectAllObjects();
        for (int i = 0; i < issuedProducts.size(); i++) {
            IssuedProduct issuedProduct = issuedProducts.get(i);
            series.getData().add(new XYChart.Data(i, issuedProduct.getQuantity()));
        }
        lineChart.getData().add(series);

        lineChart.setTitle("Transaction Volumes");
        AnchorPane.setBottomAnchor(lineChart, 0.0);
        AnchorPane.setLeftAnchor(lineChart, 0.0);
        AnchorPane.setTopAnchor(lineChart, 0.0);
        AnchorPane.setRightAnchor(lineChart, 0.0);
        chartContainer.getChildren().removeAll();
        chartContainer.getChildren().add(lineChart);

        int totalProducts = 0;
        int totalVendors = 0;
        for (Product product :
                Product.selectAllObjects()) {
            totalProducts += product.getQuantity();
        }
        totalVendors = Vendor.selectAllObjects().size();

        productCountLabel.setText(String.valueOf(totalProducts));
        vendorCountLabel.setText(String.valueOf(totalVendors));
    }
}
