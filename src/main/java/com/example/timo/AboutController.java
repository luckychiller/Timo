package com.example.timo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label Hello;
    @FXML
    private Label Story;
    @FXML
    private Button Back;
    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Timo-view.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,750,610);
        stage.setTitle("Timo");
        stage.setScene(scene);
        stage.show();
    }
}
