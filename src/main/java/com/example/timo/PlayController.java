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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import javax.swing.*;

public class PlayController extends Pane {
    private final ImageView[][] PieceHolder=new ImageView[8][8];
    private final StackPane[][] stackPanes=new StackPane[8][8];
    private final char[][] boardRep=new char[8][8];
    private char[] pieceLocation=new char[2];

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
    // Array of file paths for each piece image, ordered by piece type

    private static final int BOARD_SIZE = 8;
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
            madeMoveList.setText("----------\n");
        }
        frame.setVisible(false);
        frame.dispose();
        return loadLastGame;
    }
    private void displayGame(String GameString) {
        String[] fenparts= GameString.split(" ");
        String[] boardRows = fenparts[0].split("/");
        // Split the FEN string to get the board layout


        for (int i = 0; i < BOARD_SIZE; i++) {
            String boardRow = boardRows[i];
            // Get the row of the board, reversed for JavaFX coordinate system
            int cellpos=0;
            for (int j = 0; j < boardRow.length(); j++) {
                char boardChar = boardRow.charAt(j);
                // Get the character representing the piece at the current position

                if (Character.isDigit(boardChar)) {
                    // If the character represents an empty space, skip it
                    int numSpaces = Character.getNumericValue(boardChar);
                    cellpos=cellpos+numSpaces;
                    //continue;
                }
                else {
                    int index = 0;
                    if (Character.isUpperCase(boardChar)) {
                        // If the character represents a white piece, use index 0-5
                        index = "RNBQKP".indexOf(boardChar);
                        PieceHolder[i][cellpos].setImage(new Image(pieceImages[index]));
                        boardRep[i][cellpos]=boardChar;
                        cellpos=cellpos+1;
                    }
                    else if (Character.isLowerCase(boardChar)){
                        // If the character represents a black piece, use index 6-11
                        index = "rnbqkp".indexOf(boardChar) + 6;
                        PieceHolder[i][cellpos].setImage(new Image(pieceImages[index]));
                        boardRep[i][cellpos]=boardChar;
                        cellpos=cellpos+1;
                    }
                    // Set the image of the ImageView based on the piece type
                }
            }
        }
    }
    public void RespondToClickedCell(int Row,int Col) {

    }
    @FXML
    protected void OnStartGameClicked() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                stackPanes[row][col] = new StackPane();
                boardRep[row][col]='-';
                PieceHolder[row][col] = new ImageView();
                GridArray.setRowIndex(stackPanes[row][col], row);
                GridArray.setColumnIndex(stackPanes[row][col], col);
                GridArray.getChildren().add(stackPanes[row][col]);
                PieceHolder[row][col].setPreserveRatio(true);
                PieceHolder[row][col].setFitHeight(62.5);
                PieceHolder[row][col].setFitWidth(68.75);
                stackPanes[row][col].getChildren().add(PieceHolder[row][col]);
                int finalRow=row;
                int finalCol=col;
                stackPanes[row][col].setOnMouseClicked(event -> {
                    System.out.printf("Cell (%d, %d) clicked\n", finalRow, finalCol);
                    RespondToClickedCell(finalRow,finalCol);
                });
            }
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if((row+col)%2==0){
                    stackPanes[row][col].setStyle("-fx-background-color: brown;");
                }
                else{
                    stackPanes[row][col].setStyle("-fx-background-color: white;");
                }
            }
        }
        boolean bit= inQuire();
        if (bit) {
            String savedGame = "8/4R2p/6pk/3P4/1P5q/5p2/r4P2/4QBK1 w - - 0 19";
            displayGame(savedGame);
            WhiteTurn.setSelected(true);
            BlackTurn.setSelected(false);
        }
        else {
            String newGameString = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
            displayGame(newGameString);
            WhiteTurn.setSelected(true);
            BlackTurn.setSelected(false);
        }
    }
    @FXML
    public void onBoardClicked(MouseEvent event){
        ChessPiece piece = (ChessPiece) event.getSource();
        int row = GridArray.getRowIndex(piece);
        int col = GridArray.getColumnIndex(piece);
        System.out.println(row+" <-> "+ col+"\n");
    }
    @FXML
    public void onPiecePressed(MouseEvent event) {
        ChessPiece piece = (ChessPiece) event.getSource();
        int row = GridArray.getRowIndex(piece);
        int col = GridArray.getColumnIndex(piece);
        // Save initial location of the piece

        Dragboard dragboard = piece.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        content.putImage(piece.getImage());
        dragboard.setContent(content);
        event.consume();
    }
    @FXML
    public void onSquareDropped(DragEvent event) {
        ChessPiece piece = (ChessPiece) event.getGestureSource();
        int row = GridArray.getRowIndex(piece);
        int col = GridArray.getColumnIndex(piece);
        // Calculate new location of the piece based on the square it was dropped on
        // Update the piece's location and the chessboard
        event.setDropCompleted(true);
        event.consume();
    }
    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        System.out.println("Saving present game...");
        //SaveThePresentGameString();
        System.out.println("Done");
        Parent root = FXMLLoader.load(getClass().getResource("Timo-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 750, 610);
        stage.setTitle("Timo");
        stage.setScene(scene);
        stage.show();
    }
}