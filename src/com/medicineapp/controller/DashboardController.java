package com.medicineapp.controller;

import com.medicineapp.model.Medicine;
import com.medicineapp.view.DashboardView;

public class DashboardController {
    
    private DashboardView view;

    public DashboardController(DashboardView view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.getBtnAddMedicine().setOnAction(e -> {
            handleAddMedicineClick();
        });
        startReminderSystem();
    }


    private void handleAddMedicineClick() {
        com.medicineapp.view.AddMedicineView addView = new com.medicineapp.view.AddMedicineView();
        
        addView.getBtnCancel().setOnAction(event -> {
            addView.close();
        });

        addView.getBtnSave().setOnAction(event -> {
            String name = addView.getTxtName().getText();
            String dosage = addView.getTxtDosage().getText();
            String time = addView.getTxtTime().getText();
            
            Medicine newMedicine = new Medicine(name, dosage, time, "Pending");
            
            view.getMedicineTable().getItems().add(newMedicine);
            
            System.out.println("Medicine added to table -> Name: " + name);
            
            addView.close(); 
        });

        addView.show();
    }
    
    private void startReminderSystem() {
        javafx.animation.Timeline timeline = new javafx.animation.Timeline(
            new javafx.animation.KeyFrame(javafx.util.Duration.seconds(10), event -> {
                checkMedicineTimes();
            })
        );
        timeline.setCycleCount(javafx.animation.Timeline.INDEFINITE);
        timeline.play();
    }

    private void checkMedicineTimes() {
        java.time.LocalTime now = java.time.LocalTime.now();
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("hh:mm a", java.util.Locale.ENGLISH);
        String currentTime = now.format(formatter); 

        for (com.medicineapp.model.Medicine med : view.getMedicineTable().getItems()) {
            
            if (med.getTime().toUpperCase().equals(currentTime.toUpperCase()) && med.getStatus().equals("Pending")) {
                showAlarmPopup(med);
                med.setStatus("Alerted"); 
                view.getMedicineTable().refresh(); 
            }
        }
    }

    private void showAlarmPopup(com.medicineapp.model.Medicine med) {
        
        java.awt.Toolkit.getDefaultToolkit().beep();

        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
        alert.setTitle("Medicine Time!");
        alert.setHeaderText("It's time to take your medicine!");
        alert.setContentText("Medicine Name: " + med.getName() + "\nDosage: " + med.getDosage());
        
        alert.show(); 
    }
}