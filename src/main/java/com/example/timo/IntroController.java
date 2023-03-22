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

public class IntroController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label TimoText;
    @FXML
    private Label ChessText;
    @FXML
    private Button Play;
    @FXML
    private Button Statistics;
    @FXML
    private Button How_To_Play;
    @FXML
    private Button About;

    @FXML
    private Label Hidden_Label;

    @FXML
    protected void onPlayButtonClick(ActionEvent event) throws IOException {
        Hidden_Label.setText("No Levels so far");
        root= FXMLLoader.load(getClass().getResource("Play-view.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,760,690);
        stage.setTitle("Timo ->Play");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onStatisticsButtonClick(ActionEvent event) throws IOException {
        Hidden_Label.setText("No data so far");
        root= FXMLLoader.load(getClass().getResource("Statistics-view.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,760,690);
        stage.setTitle("Timo ->Statistics");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onHowToPlayButtonClick(ActionEvent event) throws IOException {
        Hidden_Label.setText("No idea so far");
        root= FXMLLoader.load(getClass().getResource("How-To-Play-view.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,760,690);
        stage.setTitle("Timo -> How to play");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onAboutButtonClick(ActionEvent event) throws IOException {
        Hidden_Label.setText("Its the GIANTS");
        root= FXMLLoader.load(getClass().getResource("About-view.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,760,690);
        stage.setTitle("Timo -> About");
        stage.setScene(scene);
        stage.show();
    }
}