package com.example.timo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HowToPlayController {
    @FXML
    private Button BackButton;
    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        System.out.println("Done");
        Parent root = FXMLLoader.load(getClass().getResource("Timo-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 750, 610);
        stage.setTitle("Timo");
        stage.setScene(scene);
        stage.show();
    }
}
