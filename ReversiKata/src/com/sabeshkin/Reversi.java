package com.sabeshkin;

public class Reversi {

    static int columnAmount = 8;
    static int rowAmount = 8;

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
    }

    

    /**
     * Generate potential moves
     * @param grid
     * @return potentialMoves
     */
    public static char[][] potentialMoves(char[][] grid) {
        // цикл по всем точкам сетки
        char[][] potentialMoves = new char[rowAmount+1][columnAmount];
        for (int i = 0; i < rowAmount; i++) {
            for (int k = 0; k < columnAmount; k++) {
                /**
                 * TODO: добавить проверку
                 * на допустимые значения по всем направлениям
                 * для данной точки
                 * и если все ок, то ставить '0'
                 * иначе оставлять '.'
                 */
                potentialMoves[i][k] = '0';
            }
        }
        return potentialMoves;
    }
}
