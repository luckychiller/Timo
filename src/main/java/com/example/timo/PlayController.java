package com.example.timo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import java.io.IOException;
import javax.swing.*;

public class PlayController extends Pane {
    private ImageView[][] PieceHolder=new ImageView[8][8];
    private final StackPane[][] stackPanes=new StackPane[8][8];
    private static char[][] boardRep=new char[8][8];
    private char[][] suggestedMove=new char[8][8];
    private static final int BOARD_SIZE = 8;
    private int[] spirepiece=new int[2];
    private static int Whotomove=0;
    private int PlayMode;
    private int startConst=0;
    @FXML
    private Button Back;
    @FXML
    private Button StartGame;
    @FXML
    private ComboBox<String> GameMode;
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

    public static String getFENForPresentGame() {
        StringBuilder fen = new StringBuilder();
        for (int row = 0; row < 8; row++) {
            int emptySquares = 0;
            for (int col = 0; col < 8; col++) {
                char piece = boardRep[row][col];
                if (piece == '\0') {
                    emptySquares++;
                } else {
                    if (emptySquares > 0) {
                        fen.append(emptySquares);
                        emptySquares = 0;
                    }
                    fen.append(piece);
                }
            }
            if (emptySquares > 0) {
                fen.append(emptySquares);
            }
            if (row < 7) {
                fen.append('/');
            }
        }

        fen.append(' ');
        if(Whotomove%2==0){fen.append("w");}else {fen.append("b");}
        fen.append(" - - 0 26");
        return fen.toString();
    }
    private boolean inQuire() {
        JFrame frame = new JFrame("Popup App");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int result = JOptionPane.showOptionDialog(frame, "Do you want to resume a previous game or load a new game?", "Game Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Resume Game", "New Game"}, "New Game");
        boolean loadLastGame;
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
        for (int i = 0; i < BOARD_SIZE; i++) {
            String boardRow = boardRows[i];
            int cellpos=0;
            for (int j = 0; j < boardRow.length(); j++) {
                char boardChar = boardRow.charAt(j);
                if (Character.isDigit(boardChar)) {
                    int numSpaces = Character.getNumericValue(boardChar);
                    cellpos=cellpos+numSpaces;
                    //continue;
                }
                else {
                    int index = 0;
                    if (Character.isUpperCase(boardChar)) {
                        index = "RNBQKP".indexOf(boardChar);
                        PieceHolder[i][cellpos].setImage(new Image(pieceImages[index]));
                        boardRep[i][cellpos]=boardChar;
                        cellpos=cellpos+1;
                    }
                    else if (Character.isLowerCase(boardChar)){
                        index = "rnbqkp".indexOf(boardChar) + 6;
                        PieceHolder[i][cellpos].setImage(new Image(pieceImages[index]));
                        boardRep[i][cellpos]=boardChar;
                        cellpos=cellpos+1;
                    }
                }
            }
        }
        if(fenparts[1].charAt(0)=='w'){
            Whotomove=0;
            WhiteTurn.setSelected(true);
            BlackTurn.setSelected(false);
        } else {
            WhiteTurn.setSelected(false);
            BlackTurn.setSelected(true);
        }
    }
    public void RespondToClickedCell(int Row,int Col) {
        if (boardRep[Row][Col] != '-') {
            spirepiece[0] = Row;
            spirepiece[1] = Col;
            ChessPiece selectedPiece = new ChessPiece(PieceHolder[Row][Col].getImage(), Row, Col, boardRep[Row][Col]);
            char[][] arrr = selectedPiece.getPossibleMoves(boardRep[Row][Col], Row, Col, boardRep);
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    suggestedMove[i][j] = arrr[i][j];
                    if (arrr[i][j] == '*') {
                        stackPanes[i][j].setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.DASHED, null, new BorderWidths(3))));
                    }
                }
            }
        } else {
            if (spirepiece[0] != -1 && spirepiece[1] != -1) {
                PieceHolder[Row][Col].setImage(PieceHolder[spirepiece[0]][spirepiece[1]].getImage());
                PieceHolder[spirepiece[0]][spirepiece[1]].setImage(null);
                Whotomove++;
                if(Whotomove%2==0){
                    WhiteTurn.setSelected(true);
                    BlackTurn.setSelected(false);
                } else {
                    WhiteTurn.setSelected(false);
                    BlackTurn.setSelected(true);
                }
            }
            spirepiece[0] = -1;
            spirepiece[1] = -1;
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (suggestedMove[i][j] == '*') {
                        stackPanes[i][j].setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.NONE, null, null)));
                        suggestedMove[i][j] = '-';
                    }
                }
            }
        }
        System.out.println();
    }
    @FXML
    protected void OnStartGameClicked() {
        spirepiece[0]=-1;
        spirepiece[1]=-1;
        GameMode.getItems().addAll("Human Vs Human","Human Vs Engine","Engine Vs Engine");
        GameMode.setValue("Human Vs Human");
        GameMode.setOnAction(e -> {
            String selectedOption = GameMode.getValue();
            System.out.println("Selected option: " + selectedOption);
        });
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
            //DatabaseController StartInstance=new DatabaseController();
            //StartInstance.GetPrevGame();
            //String savedGame=StartInstance.GetPrevGame();
            String savedGame = "8/4R2p/6pk/3P4/1P5q/5p2/r4P2/4QBK1 w - - 0 26";
            displayGame(savedGame);
        } else {
            String newGameString = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
            displayGame(newGameString);
        }
    }
    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        System.out.println("Saving present game...");
        //SaveThePresentGameString();
        String presentState=getFENForPresentGame();
        //DatabaseController InstanceForStorage=new DatabaseController();
        //InstanceForStorage.SavePresentGame(presentState);
        System.out.println("Saving Game....................Done");
        System.out.println("Saved Game: "+ presentState);
        Parent root = FXMLLoader.load(getClass().getResource("Timo-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 760, 690);
        stage.setTitle("Timo");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onComboBoxTriggered() throws Exception {
        String gmMode=GameMode.getValue();
        if(gmMode=="Human Vs Human"){
            PlayMode=0;
        } else if (gmMode=="Human Vs Engine") {
            PlayMode=1;
        } else if (gmMode=="Engine Vs Engine") {
            while(PlayMode==2){
                //Thread.sleep(1000);
                ChessEngine Robot=new ChessEngine("D:/Documents/Collection/stockfish_15.1_win_x64_avx2/stockfish.exe");
                Robot.setPosition(getFENForPresentGame());
                String NextMove=Robot.getBestMove(1000);
                System.out.println(NextMove);
                //break;
                //do next  best engine move
            }
        }
    }
}