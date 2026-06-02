package com.medicineapp.main;

import com.medicineapp.controller.DashboardController;
import com.medicineapp.view.DashboardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        DashboardView view = new DashboardView();
        
        DashboardController controller = new DashboardController(view);
        
        Scene scene = new Scene(view.getRoot(), 800, 600);
        primaryStage.setTitle("Medicine Reminder Application (Pure Java)");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}