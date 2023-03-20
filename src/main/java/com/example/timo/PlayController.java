package com.example.timo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import javax.swing.*;

public class PlayController extends Pane {
    private final StackPane [][] GridBoard = new StackPane[8][8];
    private final ImageView[][] PieceHolder=new ImageView[8][8];
    private boolean inQuire() {
        JFrame frame = new JFrame("Popup App");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int result = JOptionPane.showOptionDialog(frame, "Do you want to resume a previous game or load a new game?", "Game Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Resume Game", "New Game"}, "New Game");

        Boolean loadLastGame;
        if (result == JOptionPane.YES_OPTION) {
            loadLastGame =true;
            System.out.println("Resuming previous game...");
        } else {
            loadLastGame =false;
            System.out.println("Loading new game...");
            madeMoveList.setText("no move sofar");
        }
        frame.setVisible(false);
        frame.dispose();
        return loadLastGame;
    }
    @FXML
    private Button Back;
    @FXML
    private Button StartGame;
    @FXML
    private GridPane GridArray;
    @FXML
    private RadioButton WhiteTurn;
    @FXML
    private RadioButton BlackTurn;
    @FXML
    private Label madeMoveList;
    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        System.out.println("Saving present game...");
        System.out.println("Done");
        Parent root = FXMLLoader.load(getClass().getResource("Timo-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 750, 610);
        stage.setTitle("Timo");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void OnStartGameClicked() {
        boolean bit= inQuire();
        if (bit)
        {WhiteTurn.setSelected(true);
        BlackTurn.setSelected(false);}
        else {WhiteTurn.setSelected(false);
            BlackTurn.setSelected(true);}
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                StackPane stackPane = new StackPane();
                GridArray.setRowIndex(stackPane, row);
                GridArray.setColumnIndex(stackPane, col);
                ImageView imageView = new ImageView();
                stackPane.getChildren().add(imageView);
                PieceHolder[row][col]=imageView;
                GridBoard[row][col] = stackPane;
                GridArray.getChildren().add(stackPane);
            }
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if((row+col)%2==0){
                    GridBoard[row][col].setStyle("-fx-background-color: brown;");
                }
                else{
                    GridBoard[row][col].setStyle("-fx-background-color: white;");
                }
            }
        }
    }

    /*private static final int SQUARE_SIZE = 64;
    private Rectangle[][] squares = new Rectangle[8][8];
    private Image[][] pieces = new Image[8][8];


    StackPane stackPane = new StackPane();
stackPane.setStyle("-fx-background-color: red;");
    public PlayController() {
        // Create the board squares
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Rectangle square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);
                square.setFill((row + col) % 2 == 0 ? Color.WHITE : Color.LIGHTGRAY);
                square.setStroke(Color.BLACK);
                squares[row][col] = square;
                getChildren().add(square);
            }
        }

        // Load the piece images
        // Assumes that the images are named "wp.png", "bp.png", "wn.png", etc.
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                String filename = "";
                if (row == 1) {
                    filename = "wp.png";
                } else if (row == 6) {
                    filename = "bp.png";
                } else if (row == 0 || row == 7) {
                    if (col == 0 || col == 7) {
                        filename = "wr.png";
                    } else if (col == 1 || col == 6) {
                        filename = "wn.png";
                    } else if (col == 2 || col == 5) {
                        filename = "wb.png";
                    } else if (col == 3) {
                        filename = "wq.png";
                    } else {
                        filename = "wk.png";
                    }
                }
                if (!filename.equals("")) {
                    Image image = new Image(getClass().getResourceAsStream(filename));
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(SQUARE_SIZE);
                    imageView.setFitHeight(SQUARE_SIZE);
                    pieces[row][col] = image;
                    getChildren().add(imageView);
                    imageView.setLayoutX(col * SQUARE_SIZE);
                    imageView.setLayoutY(row * SQUARE_SIZE);
                }
            }
        }

        // Handle mouse clicks on the board squares
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Rectangle square = squares[row][col];
                square.setOnMouseClicked(event -> {
                    // TODO: Handle piece moves
                });
            }
        }
    }*/
}