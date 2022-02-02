package com.sabeshkin;

public class Cell {


    private Integer column;
    private Integer row;
    private char view;

    private Cell(int column, int row, char view){
        this.column =column;
        this.row=row;
        this.view = view;
    }

    public static Cell createPotentil(int column, int row){
        Cell cell = new Cell(column,row, '0');
        return cell;
    }

    public static Cell createEmpty(int column, int row){
        Cell cell = new Cell(column,row, '.');
        return cell;
    }

    public static Cell createBlack(int column, int row){
        Cell cell = new Cell(column,row, 'B');
        return cell;
    }

    public boolean isEmpty(){
        return this.view=='0';
    }

    public static Cell createWhite(int column, int row){
        Cell cell = new Cell(column,row, 'W');
        return cell;
    };

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }
    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public char getView() {
        return view;
    }

    public void setView(char view) {
        this.view = view;
    }
}
