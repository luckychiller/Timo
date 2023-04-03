package com.example.timo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Image icon = new Image("D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/icon.png");
        stage.getIcons().add(icon);
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Timo-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 760, 690);
        stage.setTitle("Timo");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}