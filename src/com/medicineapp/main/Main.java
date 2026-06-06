package com.medicineapp.main;
import com.medicineapp.controller.LoginController;

import com.medicineapp.view.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        LoginView loginView = new LoginView();
        LoginController controller = new LoginController(loginView, primaryStage);
        
        Scene scene = new Scene(loginView.getView(), 400, 300);
        
        primaryStage.setTitle("Medicine Reminder - Login");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
public static void main(String[] args) {
        launch(args);
    }
}
