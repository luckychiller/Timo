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
            }
            else if (piece == 'R' || piece == 'r') {
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
            }
            else if (piece == 'B' || piece == 'b') {
                    // Check diagonals in all four directions
                    for (int i = 1; row+i < 8 && col+i < 8; i++) {
                        if (board[row+i][col+i] == '-'||Character.isLowerCase(board[row+i][col+i]) != Character.isLowerCase(piece)) {
                            possibleMoves[row+i][col+i] = '*';
                        } else if (Character.isUpperCase(piece) != Character.isUpperCase(board[row+i][col+i])) {
                            possibleMoves[row+i][col+i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; row+i < 8 && col-i >= 0; i++) {
                        if (board[row+i][col-i] == '-') {
                            possibleMoves[row+i][col-i] = '*';
                        } else if (Character.isUpperCase(piece) != Character.isUpperCase(board[row+i][col-i])) {
                            possibleMoves[row+i][col-i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; row-i >= 0 && col+i < 8; i++) {
                        if (board[row-i][col+i] == '-') {
                            possibleMoves[row-i][col+i] = '*';
                        } else if (Character.isUpperCase(piece) != Character.isUpperCase(board[row-i][col+i])) {
                            possibleMoves[row-i][col+i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; row-i >= 0 && col-i >= 0; i++) {
                        if (board[row-i][col-i] == '-') {
                            possibleMoves[row-i][col-i] = '*';
                        } else if (Character.isUpperCase(piece) != Character.isUpperCase(board[row-i][col-i])) {
                            possibleMoves[row-i][col-i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
            }
            else if (piece == 'Q' || piece == 'q') {
                    // Check horizontal and vertical directions
                    for (int i = 0; i < 8; i++) {
                        if (board[row][i] == '-') {
                            possibleMoves[row][i] = '*';
                        } else if (Character.isUpperCase(piece) != Character.isUpperCase(board[row][i])) {
                            possibleMoves[row][i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 0; i < 8; i++) {
                        if (board[i][col] == '-') {
                            possibleMoves[i][col] = '*';
                        } else if (Character.isUpperCase(piece) != Character.isUpperCase(board[i][col])) {
                            possibleMoves[i][col] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    // Check diagonal directions
                    for (int i = 1; row+i < 8 && col+i < 8; i++) {
                        if (board[row+i][col+i] == '-') {
                            possibleMoves[row+i][col+i] = '*';
                        } else if (Character.isUpperCase(piece) != Character.isUpperCase(board[row+i][col+i])) {
                            possibleMoves[row+i][col+i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; row+i < 8 && col-i >= 0; i++) {
                        if (board[row+i][col-i] == '-') {
                            possibleMoves[row+i][col-i] = '*';
                        } else if (Character.isUpperCase(piece) != Character.isUpperCase(board[row+i][col-i])) {
                            possibleMoves[row+i][col-i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; row-i >= 0 && col+i < 8; i++) {
                        if (board[row-i][col+i] == '-') {
                            possibleMoves[row-i][col+i] = '*';
                        } else if (Character.isUpperCase(piece) != Character.isUpperCase(board[row-i][col+i])) {
                            possibleMoves[row-i][col+i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; row-i >= 0 && col-i >= 0; i++) {
                        if (board[row-i][col-i] == '-') {
                            possibleMoves[row-i][col-i] = '*';
                        } else if (Character.isUpperCase(piece) != Character.isUpperCase(board[row-i][col-i])) {
                            possibleMoves[row-i][col-i] = '*';
                            break;
                        } else {
                            break;
                        }
                    }
                }
            else if (piece == 'K' || piece == 'k') {
                //public static char[][] getKingMoves(int kingRow, int kingCol, char[][] board) {
                  //  char[][] moves = new char[8][8];
                    //char kingColor = board[kingRow][kingCol];

                    // Check all 8 possible moves for the king
                    int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
                    int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
                    for (int i = 0; i < 8; i++) {
                        int newRow = row + dr[i];
                        int newCol = col + dc[i];
                        if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                            char celll = board[newRow][newCol];
                            if (celll == '-' || (Character.isLowerCase(piece) && Character.isUpperCase(celll)) || (Character.isUpperCase(piece) && Character.isLowerCase(piece))) {
                                // Valid move - empty square or opponent's piece
                                possibleMoves[newRow][newCol] = '*';
                            }
                        }
                    }

                    // Check for castling moves
                    if (Character.isUpperCase(piece)) {
                        // White king
                        if (board[7][5] == '-' && board[7][6] == '-' && board[7][7] == 'R') {
                            // Check for kingside castle
                            if (board[7][4] == 'K' && board[7][7] == 'R') {
                                possibleMoves[7][6] = '*';
                            }
                        }
                        if (board[7][1] == '-' && board[7][2] == '-' && board[7][3] == '-' && board[7][0] == 'R') {
                            // Check for queenside castle
                            if (board[7][4] == 'K' && board[7][0] == 'R') {
                                possibleMoves[7][2] = '*';
                            }
                        }
                    } else {
                        // Black king
                        if (board[0][5] == '-' && board[0][6] == '-' && board[0][7] == 'r') {
                            // Check for kingside castle
                            if (board[0][4] == 'k' && board[0][7] == 'r') {
                                possibleMoves[0][6] = '*';
                            }
                        }
                        if (board[0][1] == '-' && board[0][2] == '-' && board[0][3] == '-' && board[0][0] == 'r') {
                            // Check for queenside castle
                            if (board[0][4] == 'k' && board[0][0] == 'r') {
                                possibleMoves[0][2] = '*';
                            }
                        }
                    }
                }
            else if (piece == 'P' || piece == 'p') {
                    // Determine direction of pawn movement based on color
                    int dir = (Character.isUpperCase(piece)) ? -1 : 1;
                    // Check if pawn can move one square forward
                    int newRow = row + dir;
                    if (newRow >= 0 && newRow < 8 && board[newRow][col] == '-') {
                        possibleMoves[newRow][col] = '*';

                        // Check if pawn can move two squares forward from starting position
                        if ((row == 6 && dir == -1) || (row == 1 && dir == 1)) {
                            newRow = row + 2 * dir;
                            if (board[newRow][col] == '-') {
                                possibleMoves[newRow][col] = '*';
                            }
                        }
                    }

                    // Check if pawn can capture diagonally
                    int[] dc = {-1, 1};
                    for (int i = 0; i < 2; i++) {
                        int newCol = col + dc[i];
                        if (newCol >= 0 && newCol < 8) {
                            char tpiece = board[row + dir][newCol];
                            if (tpiece != '-' && (Character.isLowerCase(piece) && Character.isUpperCase(tpiece) || Character.isUpperCase(piece) && Character.isLowerCase(tpiece))) {
                                // Valid capture move
                                possibleMoves[piece + dir][newCol] = '*';
                            }
                        }
                    }

                    // Check for en passant move
                    if (row == ((Character.isUpperCase(piece)) ? 3 : 4)) {
                        int[] dc1 = {-1, 1};
                        for (int i = 0; i < 2; i++) {
                            int newCol = col + dc1[i];
                            if (newCol >= 0 && newCol < 8) {
                                char tpiece = board[row][newCol];
                                if (tpiece == ((Character.isUpperCase(piece)) ? 'p' : 'P')) {
                                    char prevMove = board[row][newCol] == 'p' ? board[row - 1][newCol] : board[row + 1][newCol];
                                    if (prevMove == 'm') {
                                        // Valid en passant move
                                        possibleMoves[row + dir][newCol] = '*';
                                    }
                                }
                            }
                        }
                    }
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
//write a java function to return a 8x8 character array of all possible moves of pawn piece given its coodinate and a character array having all the present pieces in their present positions. Make it that it can take opponents piece. make it that it can also check for possible en pasant