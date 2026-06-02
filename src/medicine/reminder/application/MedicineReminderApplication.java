package com.medicineapp.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MedicineReminderApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/medicineapp/view/Dashboard.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root, 800, 600);
            
            primaryStage.setTitle("Medicine Reminder Application");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false); // Prevents users from breaking your UI layout
            primaryStage.show();
            
        } catch (Exception e) {
            System.out.println("Error loading UI: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}