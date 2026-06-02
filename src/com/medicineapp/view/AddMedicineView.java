package com.medicineapp.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddMedicineView {
    
    private Stage dialogStage;
    private TextField txtName;
    private TextField txtDosage;
    private TextField txtTime;
    private Button btnSave;
    private Button btnCancel;

    public AddMedicineView() {
        dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL); 
        dialogStage.setTitle("Add New Medicine");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(new Label("Medicine Name:"), 0, 0);
        txtName = new TextField();
        txtName.setPromptText("e.g. Napa Extra");
        grid.add(txtName, 1, 0);

        grid.add(new Label("Dosage:"), 0, 1);
        txtDosage = new TextField();
        txtDosage.setPromptText("e.g. 1 Tablet");
        grid.add(txtDosage, 1, 1);

        grid.add(new Label("Time:"), 0, 2);
        txtTime = new TextField();
        txtTime.setPromptText("e.g. 08:00 AM");
        grid.add(txtTime, 1, 2);

        btnSave = new Button("Save Medicine");
        btnSave.setStyle("-fx-background-color: #28A745; -fx-text-fill: white; -fx-font-weight: bold;");
        
        btnCancel = new Button("Cancel");
        btnCancel.setStyle("-fx-background-color: #DC3545; -fx-text-fill: white; -fx-font-weight: bold;");

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(btnSave, btnCancel);
        grid.add(hbBtn, 1, 4);

        Scene scene = new Scene(grid, 400, 300);
        dialogStage.setScene(scene);
    }

    public void show() {
        dialogStage.showAndWait();
    }

    public void close() {
        dialogStage.close();
    }

    public Button getBtnSave() { return btnSave; }
    public Button getBtnCancel() { return btnCancel; }
    public TextField getTxtName() { return txtName; }
    public TextField getTxtDosage() { return txtDosage; }
    public TextField getTxtTime() { return txtTime; }
}