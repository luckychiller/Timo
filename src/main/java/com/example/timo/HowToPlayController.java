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
import javafx.stage.Stage;

import java.io.IOException;

public class HowToPlayController {
    private final String[] pieceImages = {
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/src/main/pics/whiteRook.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/src/main/pics/whiteKnight.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/src/main/pics/whiteBishop.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/src/main/pics/whiteQueen.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/src/main/pics/whiteKing.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/src/main/pics/whitePawn.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/src/main/pics/blackRook.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/src/main/pics/blackKnight.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/src/main/pics/blackBishop.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/src/main/pics/blackQueen.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/src/main/pics/blackKing.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/src/main/pics/BlackPawn.png",
            "D:/Documents/Bachellors CSE/semester 4/CSE 4402 Visual Programming Lab/project/timo/src/main/pics/pieces.png"
    };
    @FXML
    private ImageView King;
    @FXML
    private ImageView Queen;
    @FXML
    private ImageView knight;
    @FXML
    private ImageView bishop;
    @FXML
    private ImageView rook;
    @FXML
    private ImageView pawn;
    @FXML
    private ImageView alll;

    @FXML
    private Button BackButton;
    @FXML
    void displayPieces(){
        alll.setImage(new Image(pieceImages[12]));
        pawn.setImage(new Image(pieceImages[5]));
        rook.setImage(new Image(pieceImages[6]));
        bishop.setImage(new Image(pieceImages[2]));
        knight.setImage(new Image(pieceImages[7]));
        Queen.setImage(new Image(pieceImages[3]));
        King.setImage(new Image(pieceImages[10]));
    }
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
