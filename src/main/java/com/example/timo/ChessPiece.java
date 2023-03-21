package com.example.timo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChessPiece extends ImageView {
    private int row;
    private int col;
    private char pieceChartype;
    private Image image;
    public ChessPiece(Image image, int row, int col,char rep) {
        super(image);
        this.row = row;
        this.col = col;
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
