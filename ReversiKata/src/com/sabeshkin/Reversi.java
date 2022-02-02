package com.sabeshkin;

import java.util.ArrayList;
import java.util.List;

public class Reversi {

    static int columnAmount = 8;
    static int rowAmount = 8;
    static char enemy = 'W';

    public static void main(String[] args) {
        // иницилизация входных данных
        char[][] chars = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', 'W', '.', '.', '.'},
                {'.', '.', '.', 'W', 'B', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'B'}
        };
        enemy= defineEnemy(chars);
    }

    /**
     * Define enemy from input data
     * @param chars
     * @return
     */
    public static char defineEnemy(char[][] chars){
        return chars[chars.length][0];
    }


    /**
     * Generate potential moves
     *
     * @param grid
     * @return potentialMoves
     */
    public static Cell[][] potentialMoves(Cell[][] grid, char enemy) {
        // цикл по всем точкам сетки
        Cell[][] potentialMoves = new Cell[rowAmount + 1][columnAmount];
        for (int i = 0; i < rowAmount; i++) {
            for (int k = 0; k < columnAmount; k++) {
                
                /**
                 * TODO: добавить проверку
                 * на допустимые значения по всем направлениям
                 * для данной точки
                 * и если все ок, то ставить '0'
                 * иначе оставлять '.'
                 */
                potentialMoves[i][k] = Cell.createPotentil(i, k);
            }
        }
        return potentialMoves;
    }


    /**
     * Проверка того, находится ли рядом
     * фишка противника
     *
     * @param row
     * @param column
     * @return
     */
    public static boolean isEnemy(Cell[][] grid, int row, int column, char enemy) {
        return grid[row][column].getView() == enemy;
    }


    /**
     * Generate Neighbour Points
     *
     * @param cell
     * @return
     */
    public static List generateNeighbours(Cell cell, Cell[][] grid) {

        int[][] surroundingPoints = generateSurroundingPoints(cell);
        List validNeighbors = leaveValidPoints(surroundingPoints, grid);


        return validNeighbors;
    }

    /**
     * Возвращает список только существующих соседей
     *
     * @param surroundingPoints
     * @param grid
     * @return
     */
    public static List leaveValidPoints(int[][] surroundingPoints, Cell[][] grid) {
        //из этого метода надо возвращать уже точки валидных соседей
        List validNeighborPoints = new ArrayList<Cell>();

        //цикл по точкам соседей
        for (int i = 0; i < surroundingPoints.length; i++) {
            //check neighbours points
            int neighborColumn = surroundingPoints[i][0];
            int neighborRow = surroundingPoints[i][1];
            if (isValidPoints(neighborColumn, neighborRow)) {
                Cell neighbor = grid[neighborColumn][neighborRow];
                validNeighborPoints.add(neighbor);
            }
        }
        return validNeighborPoints;
    }


    /**
     * Generate closest surrounding points
     *
     * @param cell
     * @return
     */
    public static int[][] generateSurroundingPoints(Cell cell) {
        int row = cell.getRow();
        int column = cell.getColumn();
        // 8 - count neighbors of point for two dimensional grid
        int[][] surroundingPoints = new int[8][2];

        //upper line
        surroundingPoints[0] = new int[]{column - 1, row - 1};
        surroundingPoints[1] = new int[]{column, row - 1};
        surroundingPoints[2] = new int[]{column + 1, row - 1};

        //right column
        surroundingPoints[3] = new int[]{column + 1, row};
        surroundingPoints[4] = new int[]{column + 1, row + 1};

        // bottom line
        surroundingPoints[5] = new int[]{column, row + 1};
        surroundingPoints[6] = new int[]{column - 1, row + 1};

        //left line
        surroundingPoints[7] = new int[]{column - 1, row};

        return surroundingPoints;
    }

    /**
     * Проверяет, что точки находятся в границах поля
     *
     * @param column
     * @param row
     * @return
     */
    public static boolean isValidPoints(int column, int row) {
        if (isValidColumn(column) && isValidRow(row)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Проверяет что значение колонки не выходит за пределы сетки
     *
     * @param column
     * @return
     */
    public static boolean isValidColumn(int column) {
        if (column < columnAmount && column >= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Проверяет что значение строки не выходит за пределы сетки
     *
     * @param row
     * @return
     */
    public static boolean isValidRow(int row) {
        if (row < rowAmount && row >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
