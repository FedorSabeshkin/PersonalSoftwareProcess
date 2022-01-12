import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class GameOfLife {


    static int columnAmount = 4;
    static int rowAmount = 5;


    //вывод следующего поколения по входным данным
    public static void main(String args[]) {
        // иницилизация входных данных
        char[][] chars = {
                {'.', '.', '.', '.', '.'},
                {'.', '.', '*', '.', '.'},
                {'.', '*', '*', '.', '.'},
                {'.', '.', '.', '.', '.'}
        };
        System.out.println("1 generation: ");
        printTwoDimensionalArray(chars);
        Cell[][] prevGenerationGrid = charGridToCellGrid(chars);
        Cell[][] nextGenerationGrid = generationalChange(prevGenerationGrid);
        chars = cellGridToCharGrid(nextGenerationGrid);
        System.out.println("After: ");
        printTwoDimensionalArray(chars);
    }


    /**
     * Печать двумерного массива в терминал
     *
     * @param chars
     */
    public static void printTwoDimensionalArray(char[][] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int k = 0; k < chars[i].length; k++) {
                System.out.print(chars[i][k]);
            }
            System.out.println();
        }
    }

    /**
     * Иницилизация сетки значениями из входных данных
     *
     * @param chars
     * @return Двумерный массив Cell[][] содержащий отображения значков "*" и "." в объекты Cell
     */
    public static Cell[][] charGridToCellGrid(char[][] chars) {
        Cell[][] grid = new Cell[columnAmount][rowAmount];
        //пробегаюсь в цикле по всему двумерному массиву символов
        for (int i = 0; i < chars.length; i++) {
            for (int k = 0; k < chars[i].length; k++) {
                grid[i][k] = charToCell(chars[i][k], i, k);
            }
        }
        return grid;
    }

    /**
     * Заполнение выходного массива символов данными из сетки
     *
     * @param grid
     * @return
     */
    public static char[][] cellGridToCharGrid(Cell[][] grid) {
        char[][] chars = new char[columnAmount][rowAmount];
        //пробегаюсь в цикле по всему двумерному массиву символов
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[i].length; k++) {
                Cell cell = grid[i][k];
                chars[i][k] = cellToChar(cell);
            }
        }
        return chars;
    }

    /**
     * Метод отображения объекта Cell в символы
     *
     * @param cell
     * @return
     */
    public static char cellToChar(@NotNull Cell cell) {
        boolean isLive = cell.getIsLive();
        if (isLive) {
            return '*';
        } else {
            return '.';
        }

    }


    /**
     * Метод отображения символа в объект Cell
     *
     * @param symbol - символ для обозначения "живой" или "мертвой" клетки
     * @param column - номер столбца в котором будет находится объект Cell в который отобразится символ
     * @param row    - номер строки в котором будет находится объект Cell в который отобразится символ
     * @return Объект Cell, находящейся в конкретной позиции, который является отображение входного символа
     */
    public static Cell charToCell(char symbol, int column, int row) {
        if (symbol == '*') {
            return Cell.createLive(column, row);
        } else {
            return Cell.createDead(column, row);
        }

    }

    /**
     * Построение нового поколение сетки
     *
     * @param prevGenerationGrid - Cell[][] актуального поколения
     * @return Cell[][] - следующего поколения
     */
    public static Cell[][] generationalChange(Cell[][] prevGenerationGrid) {
        Cell[][] grid = prevGenerationGrid.clone();
        grid = calculateLiveNeighboursForAll(grid);

        Cell[][] nextGenerationGrid = new Cell[columnAmount][rowAmount];
        // цикл по всем точкам сетки
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[i].length; k++) {

                Cell cell = grid[i][k];
                int column = cell.getColumn();
                int row = cell.getRow();
                nextGenerationGrid[i][k] = createNextGenerationCell(cell, column, row);
            }
        }

        return nextGenerationGrid;
    }

    public static Cell createNextGenerationCell(Cell cell, int column, int row) {
        if (!isSameNextGeneration(cell)) {
            return defineAnotherCell(cell, column, row);
        } else {
            return defineSameCell(cell, column, row);
        }
    }

    public static Cell defineAnotherCell(Cell cell, int column, int row) {
        if (isDeadNextGeneration(cell)) {
            return Cell.createDead(column, row);
        } else {
            return Cell.createLive(column, row);
        }

    }

    public static Cell defineSameCell(Cell cell, int column, int row) {
        if (isLiveNextGeneration(cell)) {
            return Cell.createLive(column, row);
        } else {
            return Cell.createSame(cell);
        }

    }

    /**
     * Подсчет кол-ва соседей для всех точек
     *
     * @param gridForCount
     * @return Cell[][], где каждый обяъект Cell так же содержит информацию о кол-ве своих живых соседей
     */
    public static Cell[][] calculateLiveNeighboursForAll(Cell[][] gridForCount) {
        Cell[][] grid = gridForCount.clone();
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[i].length; k++) {
                Cell cell = grid[i][k];
                int liveNeighbours = calculateLiveNeighbours(cell, grid);
                cell.setLiveNeighbours(liveNeighbours);

                grid[i][k] = cell;
            }
        }
        return grid;
    }

    /**
     * Подсчет живых кол-ва соседей для конкретной точки
     *
     * @param cell клетка
     * @param grid сетка в которой она находится
     * @return кол-во живых соседей для точки
     */
    public static int calculateLiveNeighbours(Cell cell, Cell[][] grid) {
        int[][] neighborPoints = generateNeighbourPoints(cell);
        int liveNeighbours = 0;
        //цикл по точкам соседей
        for (int i = 0; i < neighborPoints.length; i++) {
            int neighborColumn = neighborPoints[i][0];
            int neighborRow = neighborPoints[i][1];
            if (isValidPoints(neighborColumn, neighborRow)) {
                Cell neighbor = grid[neighborColumn][neighborRow];
                if (isLiveNeighbour(neighbor)) {
                    liveNeighbours++;
                }
            }
        }
        return liveNeighbours;
    }

    /**
     * Будет ли клетка "Мертва" в следующем поколении
     *
     * @param cell
     * @return
     */
    public static boolean isDeadNextGeneration(Cell cell) {
        int liveNeighbours = cell.getLiveNeighbours();
        if (liveNeighbours > 3 || liveNeighbours < 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Будет ли клетка "Жива" в следующем поколении
     *
     * @param cell
     * @return
     */
    public static boolean isLiveNextGeneration(Cell cell) {
        int liveNeighbours = cell.getLiveNeighbours();
        if (liveNeighbours == 3) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Останется ли клетка в том же состоянии в следующем поколении
     *
     * @param cell
     * @return
     */
    public static boolean isSameNextGeneration(Cell cell) {
        int liveNeighbours = cell.getLiveNeighbours();
        if (liveNeighbours == 2 || liveNeighbours == 3) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Generate Neighbour Points
     *
     * @param cell
     * @return
     */
    public static int[][] generateNeighbourPoints(@NotNull Cell cell) {
        int row = cell.getRow();
        int column = cell.getColumn();
        // 8 - count neighbors of point for two dimensional grid
        int[][] neighbors = new int[8][2];

        //upper line
        neighbors[0] = new int[]{column - 1, row - 1};
        neighbors[1] = new int[]{column, row - 1};
        neighbors[2] = new int[]{column + 1, row - 1};

        //right column
        neighbors[3] = new int[]{column + 1, row};
        neighbors[4] = new int[]{column + 1, row + 1};

        // bottom line
        neighbors[5] = new int[]{column, row + 1};
        neighbors[6] = new int[]{column - 1, row + 1};

        //left line
        neighbors[7] = new int[]{column - 1, row};

        return neighbors;
    }


    /**
     * Провереят, что сосед клетки "жив"
     *
     * @param cell
     * @return
     */
    public static boolean isLiveNeighbour(@NotNull Cell cell) {
        return cell.getIsLive();
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
    @Contract(pure = true)
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
    @Contract(pure = true)
    public static boolean isValidRow(int row) {
        if (row < rowAmount && row >= 0) {
            return true;
        } else {
            return false;
        }
    }

}
