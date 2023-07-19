package com.group20.inventory.inventory.controllers;

import com.group20.inventory.inventory.models.IssuedProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ReportPageController implements Initializable {
    public PieChart pieChartView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HashMap<String, Float> vendorGrossAmount = new HashMap<>();
        for (IssuedProduct issuedProduct :
                IssuedProduct.selectAllObjects()) {
            String key = issuedProduct.getVendorName();
            float amount = 0;
            if (vendorGrossAmount.containsKey(key))
                amount = vendorGrossAmount.get(key);
            vendorGrossAmount.put(key, amount + issuedProduct.getGrossPrice());
        }

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        vendorGrossAmount.forEach((key, val) -> {
            System.out.println(key + " " + val);
            pieChartData.add(new PieChart.Data(key, val));
        });

        pieChartView.setData(pieChartData);
    }

    public void reloadPage() {

    }

}
