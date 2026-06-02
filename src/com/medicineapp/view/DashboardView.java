package com.medicineapp.view;

import com.medicineapp.model.Medicine;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DashboardView {
    
    private BorderPane root;
    private Button btnAddMedicine;
    private TableView<Medicine> medicineTable;

    public DashboardView() {
        root = new BorderPane();
        root.setStyle("-fx-background-color: #F0F4F8;");
        buildUI();
    }

    private void buildUI() {
        // --- 1. Top Section (Header) ---
        VBox header = new VBox();
        header.setAlignment(Pos.CENTER);
        header.setPrefHeight(80.0);
        header.setStyle("-fx-background-color: #007BFF;");
        
        Label titleLabel = new Label("Medicine Dashboard");
        titleLabel.setFont(Font.font("System", FontWeight.BOLD, 28));
        titleLabel.setStyle("-fx-text-fill: white;");
        header.getChildren().add(titleLabel);
        
        root.setTop(header);

        VBox centerBox = new VBox();
        centerBox.setPadding(new Insets(20));
        centerBox.setSpacing(15);
        
        Label tableLabel = new Label("Today's Schedule");
        tableLabel.setFont(Font.font("System", FontWeight.BOLD, 20));
        tableLabel.setStyle("-fx-text-fill: #2c3e50;");
        
        medicineTable = new TableView<>();
        
        TableColumn<Medicine, String> colName = new TableColumn<>("Medicine Name");
        colName.setPrefWidth(250);
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Medicine, String> colDosage = new TableColumn<>("Dosage");
        colDosage.setPrefWidth(150);
        colDosage.setCellValueFactory(new PropertyValueFactory<>("dosage"));
        
        TableColumn<Medicine, String> colTime = new TableColumn<>("Time");
        colTime.setPrefWidth(150);
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        TableColumn<Medicine, String> colStatus = new TableColumn<>("Status");
        colStatus.setPrefWidth(200);
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        medicineTable.getColumns().addAll(colName, colDosage, colTime, colStatus);
        centerBox.getChildren().addAll(tableLabel, medicineTable);
        
        root.setCenter(centerBox);

        HBox bottomBox = new HBox();
        bottomBox.setAlignment(Pos.CENTER_RIGHT);
        bottomBox.setPadding(new Insets(20));
        
        btnAddMedicine = new Button(" + Add New Medicine ");
        btnAddMedicine.setStyle("-fx-background-color: #28A745; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 16px; -fx-background-radius: 5;");
        btnAddMedicine.setPadding(new Insets(10, 20, 10, 20));
        
        bottomBox.getChildren().add(btnAddMedicine);
        root.setBottom(bottomBox);
    }

    public BorderPane getRoot() {
        return root;
    }

    public Button getBtnAddMedicine() {
        return btnAddMedicine;
    }
    
    public TableView<Medicine> getMedicineTable() {
        return medicineTable;
    }
}