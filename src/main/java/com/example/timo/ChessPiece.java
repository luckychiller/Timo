package com.example.timo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChessPiece extends ImageView {
    private int row;
    private int col;
    public ChessPiece(Image image, int row, int col,char rep) {
        super(image);
        this.row = row;
        this.col = col;
    }
    public static char[][] getPossibleMoves(char piece, int row, int col, char[][] board) {
        char[][] possibleMoves = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                possibleMoves[i][j] = '-';
            }
        }
        if (piece == 'N' || piece == 'n') {
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
            for (int i = col - 1; i >= 0; i--) {
                if (board[row][i] == '-') {
                    possibleMoves[row][i] = '*';
                } else if (Character.isLowerCase(board[row][i]) != Character.isLowerCase(piece)) {
                    possibleMoves[row][i] = '*';
                    break;
                } else {
                    break;
                }
            }

            for (int i = col + 1; i < 8; i++) {
                if (board[row][i] == '-') {
                    possibleMoves[row][i] = '*';
                } else if (Character.isLowerCase(board[row][i]) != Character.isLowerCase(piece)) {
                    possibleMoves[row][i] = '*';
                    break;
                } else {
                    break;
                }
            }

            for (int i = row - 1; i >= 0; i--) {
                if (board[i][col] == '-') {
                    possibleMoves[i][col] = '*';
                } else if (Character.isLowerCase(board[i][col]) != Character.isLowerCase(piece)) {
                    possibleMoves[i][col] = '*';
                    break;
                } else {
                    break;
                }
            }
            for (int i = row + 1; i < 8; i++) {
                if (board[i][col] == '-') {
                    possibleMoves[i][col] = '*';
                } else if (Character.isLowerCase(board[i][col]) != Character.isLowerCase(piece)) {
                    possibleMoves[i][col] = '*';
                    break;
                } else {
                    break;
                }
            }
        }
        else if (piece == 'B' || piece == 'b') {
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
            for (int i = 0; i < 8; i++) {
                if (board[row][i] == '-' ) {
                    possibleMoves[row][i] = '*';
                } else if (Character.isLowerCase(board[row][i]) != Character.isLowerCase(piece)) {
                    possibleMoves[row][i] = '*';
                    break;
                } else {
                    break;
                }
            }
            for (int i = 0; i < 8; i++) {
                if (board[i][col] == '-' ) {
                    possibleMoves[i][col] = '*';
                } else if (Character.isLowerCase(board[i][col]) != Character.isLowerCase(piece)) {
                    possibleMoves[i][col] = '*';
                    break;
                } else {
                    break;
                }
            }
            for (int i = 1; i < 8; i++) {
                if (row - i >= 0 && col - i >= 0) {
                    if (board[row-i][col-i] == '-') {
                        possibleMoves[row-i][col-i] = '*';
                    } else if (Character.isLowerCase(board[row-i][col-i]) != Character.isLowerCase(piece)) {
                        possibleMoves[row-i][col-i] = '*';
                        break;
                    } else {
                        break;
                    }
                }
                if (row - i >= 0 && col + i < 8) {
                    if (board[row-i][col+i] == '-') {
                        possibleMoves[row-i][col+i] = '*';
                    } else if (Character.isLowerCase(board[row-i][col+i]) != Character.isLowerCase(piece)) {
                        possibleMoves[row-i][col+i] = '*';
                        break;
                    } else {
                        break;
                    }
                }
                if (row + i < 8 && col - i >= 0) {
                    if (board[row+i][col-i] == '-') {
                        possibleMoves[row+i][col-i] = '*';
                    } else if (Character.isLowerCase(board[row+i][col-i]) != Character.isLowerCase(piece)) {
                        possibleMoves[row+i][col-i] = '*';
                        break;
                    } else {
                        break;
                    }
                }
                if (row + i < 8 && col + i < 8) {
                    if (board[row+i][col+i] == '-') {
                        possibleMoves[row+i][col+i] = '*';
                    } else if (Character.isLowerCase(board[row+i][col+i]) != Character.isLowerCase(piece)) {
                        possibleMoves[row+i][col+i] = '*';
                        break;
                    } else {
                        break;
                    }
                }
            }
        } if (piece == 'Q' || piece == 'q') {
            for (int i = 0; i < 8; i++) {
                if (board[row][i] == '-' ) {
                    possibleMoves[row][i] = '*';
                } else if (Character.isLowerCase(board[row][i]) != Character.isLowerCase(piece)) {
                    possibleMoves[row][i] = '*';
                    break;
                } else {
                    break;
                }
            }
            for (int i = 0; i < 8; i++) {
                if (board[i][col] == '-' ) {
                    possibleMoves[i][col] = '*';
                } else if (Character.isLowerCase(board[i][col]) != Character.isLowerCase(piece)) {
                    possibleMoves[i][col] = '*';
                    break;
                } else {
                    break;
                }
            }
            for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == '-') {
                    possibleMoves[i][j] = '*';
                } else if (Character.isLowerCase(board[i][j]) != Character.isLowerCase(piece)) {
                    possibleMoves[i][j] = '*';
                    break;
                } else {
                    break;
                }
            }
            for (int i = row+1, j = col+1; i < 8 && j < 8; i++, j++) {
                if (board[i][j] == '-') {
                    possibleMoves[i][j] = '*';
                } else if (Character.isLowerCase(board[i][j]) != Character.isLowerCase(piece)) {
                    possibleMoves[i][j] = '*';
                    break;
                } else {
                    break;
                }
            }
            for (int i = row-1, j = col+1; i >= 0 && j < 8; i--, j++) {
                if (board[i][j] == '-') {
                    possibleMoves[i][j] = '*';
                } else if (Character.isLowerCase(board[i][j]) != Character.isLowerCase(piece)) {
                    possibleMoves[i][j] = '*';
                    break;
                } else {
                    break;
                }
            }
            for (int i = row+1, j = col-1; i < 8 && j >= 0; i++, j--) {
                if (board[i][j] == '-') {
                    possibleMoves[i][j] = '*';
                } else if (Character.isLowerCase(board[i][j]) != Character.isLowerCase(piece)) {
                    possibleMoves[i][j] = '*';
                    break;
                } else {
                    break;
                }
            }
        }
        else if (piece == 'K' || piece == 'k') {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int newRow = row + i;
                    int newCol = col + j;
                    if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                        if (board[newRow][newCol] == '-' || Character.isLowerCase(board[newRow][newCol]) != Character.isLowerCase(piece)) {
                            possibleMoves[newRow][newCol] = '*';
                        }
                    }
                }
            }
        }
        else if (piece == 'P' || piece == 'p') {
            int direction = (piece == 'P') ? -1 : 1; // white or black pawn
            if (row + direction >= 0 && row + direction < 8 && board[row + direction][col] == '-') {
                possibleMoves[row + direction][col] = '*';
                if ((row == 6 && direction == -1) || (row == 1 && direction == 1)) {
                    if (board[row + 2 * direction][col] == '-') {
                        possibleMoves[row + 2 * direction][col] = '*';
                    }
                }
            }
            if (col - 1 >= 0 && row + direction >= 0 && row + direction < 8 && Character.isLowerCase(board[row + direction][col - 1]) != Character.isLowerCase(piece)) {
                possibleMoves[row + direction][col - 1] = '*';
            }
            if (col + 1 < 8 && row + direction >= 0 && row + direction < 8 && Character.isLowerCase(board[row + direction][col + 1]) != Character.isLowerCase(piece)) {
                possibleMoves[row + direction][col + 1] = '*';
            }
        }
        return possibleMoves;
    }
}
