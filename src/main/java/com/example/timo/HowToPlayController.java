package com.example.timo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HowToPlayController {
    private final String[] pieceImages = {
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/Timo/src/main/pics/whiteRook.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/Timo/src/main/pics/whiteKnight.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/Timo/src/main/pics/whiteBishop.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/Timo/src/main/pics/whiteQueen.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/Timo/src/main/pics/whiteKing.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/Timo/src/main/pics/whitePawn.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/Timo/src/main/pics/blackRook.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/Timo/src/main/pics/blackKnight.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/Timo/src/main/pics/blackBishop.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/Timo/src/main/pics/blackQueen.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/Timo/src/main/pics/blackKing.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/Timo/src/main/pics/BlackPawn.png"
    };
    @FXML
    private StackPane King;
    @FXML
    private StackPane Queen;
    @FXML
    private StackPane knight;
    @FXML
    private StackPane bishop;
    @FXML
    private StackPane rook;
    @FXML
    private StackPane pawn;
    @FXML
    private StackPane alll;

    @FXML
    private Button BackButton;
    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        System.out.println("Done");
        Parent root = FXMLLoader.load(getClass().getResource("Timo-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 760, 690);
        stage.setTitle("Timo");
        stage.setScene(scene);
        stage.show();
    }
}
