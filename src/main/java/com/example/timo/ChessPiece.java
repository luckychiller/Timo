package com.example.timo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChessPiece extends ImageView {
    private int row;
    private int col;
    private char pieceChartype;
    private Image image;
    private char[][] validNextPos= new char[8][8];

    public ChessPiece(Image image, int row, int col,char rep) {
        super(image);
        this.row = row;
        this.col = col;
    }

    public static char[][] getPossibleMoves(char piece, int row, int col, char[][] board) {
            // Initialize the array of possible moves
            char[][] possibleMoves = new char[8][8];
            // Check if the piece is a knight
            if (piece == 'N' || piece == 'n') {
                // Check all 8 possible knight moves
                int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
                int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};
                for (int i = 0; i < dx.length; i++) {
                    int newRow = row + dx[i];
                    int newCol = col + dy[i];
                    if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                        if (board[newRow][newCol] == '-' || Character.isLowerCase(board[newRow][newCol]) != Character.isLowerCase(piece)) {
                            possibleMoves[newRow][newCol]='*';
                        }
                    }
                }
            } else if (piece == 'R' || piece == 'r') {
                //public static char[][] possibleRookMoves(int rookX, int rookY, char[][] board, char opponent) {
                    // Initialize the result array
                    //char[][] result = new char[8][8];

                    // Check all possible moves in the horizontal direction
                    for (int i = 0; i < 8; i++) {
                        if (board[row][i] == '-' ) {
                            possibleMoves[row][i] = '*'; // Possible move
                        } else if (Character.isLowerCase(board[row][i]) != Character.isLowerCase(piece)) {
                            possibleMoves[row][i] = '*'; // Possible capture
                            break;
                        } else {
                            break; // Blocked by a friendly piece
                        }
                    }

                    // Check all possible moves in the vertical direction
                    for (int i = 0; i < 8; i++) {
                        if (board[i][col] == '-' ) {
                            possibleMoves[i][col] = '*'; // Possible move
                        } else if (Character.isLowerCase(board[i][col]) != Character.isLowerCase(piece)) {
                            possibleMoves[i][col] = '*'; // Possible capture
                            break;
                        } else {
                            break; // Blocked by a friendly piece
                        }
                    }
                    return possibleMoves;

            } else if (piece == 'B' || piece == 'b') {
                    // Check diagonals in all four directions
                    for (int i = 1; row+i < 8 && col+i < 8; i++) {
                        if (board[row+i][col+i] == 0) {
                            possibleMoves[row+i][col+i] = '*';
                        } else if (Character.isUpperCase(board[row][col]) != Character.isUpperCase(board[row+i][col+i])) {
                            possibleMoves[row+i][col+i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; row+i < 8 && col-i >= 0; i++) {
                        if (board[row+i][col-i] == 0) {
                            possibleMoves[row+i][col-i] = '*';
                        } else if (Character.isUpperCase(board[row][col]) != Character.isUpperCase(board[row+i][col-i])) {
                            possibleMoves[row+i][col-i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; row-i >= 0 && col+i < 8; i++) {
                        if (board[row-i][col+i] == 0) {
                            possibleMoves[row-i][col+i] = '*';
                        } else if (Character.isUpperCase(board[row][col]) != Character.isUpperCase(board[row-i][col+i])) {
                            possibleMoves[row-i][col+i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; row-i >= 0 && col-i >= 0; i++) {
                        if (board[row-i][col-i] == 0) {
                            possibleMoves[row-i][col-i] = '*';
                        } else if (Character.isUpperCase(board[row][col]) != Character.isUpperCase(board[row-i][col-i])) {
                            possibleMoves[row-i][col-i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    return possibleMoves;
            } else if (piece == 'Q' || piece == 'q') {
                    // Check horizontal and vertical directions
                    for (int i = 0; i < 8; i++) {
                        if (board[row][i] == 0) {
                            possibleMoves[row][i] = '*';
                        } else if (Character.isUpperCase(board[row][col]) != Character.isUpperCase(board[row][i])) {
                            possibleMoves[row][i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 0; i < 8; i++) {
                        if (board[i][col] == 0) {
                            possibleMoves[i][col] = '*';
                        } else if (Character.isUpperCase(board[row][col]) != Character.isUpperCase(board[i][col])) {
                            possibleMoves[i][col] = '*';
                            break;
                        } else {
                            break;
                        }
                    }

                    // Check diagonal directions
                    for (int i = 1; row+i < 8 && col+i < 8; i++) {
                        if (board[row+i][col+i] == 0) {
                            possibleMoves[row+i][col+i] = '*';
                        } else if (Character.isUpperCase(board[row][col]) != Character.isUpperCase(board[row+i][col+i])) {
                            possibleMoves[row+i][col+i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; row+i < 8 && col-i >= 0; i++) {
                        if (board[row+i][col-i] == 0) {
                            possibleMoves[row+i][col-i] = '*';
                        } else if (Character.isUpperCase(board[row][col]) != Character.isUpperCase(board[row+i][col-i])) {
                            possibleMoves[row+i][col-i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; row-i >= 0 && col+i < 8; i++) {
                        if (board[row-i][col+i] == 0) {
                            possibleMoves[row-i][col+i] = '*';
                        } else if (Character.isUpperCase(board[row][col]) != Character.isUpperCase(board[row-i][col+i])) {
                            possibleMoves[row-i][col+i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; row-i >= 0 && col-i >= 0; i++) {
                        if (board[row-i][col-i] == 0) {
                            possibleMoves[row-i][col-i] = '*';
                        } else if (Character.isUpperCase(board[row][col]) != Character.isUpperCase(board[row-i][col-i])) {
                            possibleMoves[row-i][col-i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    return possibleMoves;
            } else if (piece == 'K' || piece == 'k') {
//write a java function to return a 8x8 character array of all possible moves of king piece given its coodinate and a character array having all the present pieces in their present positions. Make it that it can take opponents piece
            } else if (piece == 'P' || piece == 'p') {

            }
            return possibleMoves;
        }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public char getType() {
        return pieceChartype;
    }
    public void setType(char pieCtyp) {
        this.pieceChartype = pieCtyp;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
}
