import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class GameOfLife {


    static int columnAmount = 4;
    static int rowAmount = 5;

    // проверить что бы была иммутабельность при заполнении новых соседей,
    // иначе можем слишком увеличить кол-во соседей у клетки
    // что бы при создании новой таблицы обнулялось кол-во известных соседей у каждой клетки


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

    // печать двумерного массива
    public static void printTwoDimensionalArray(char[][] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int k = 0; k < chars[i].length; k++) {
                System.out.print(chars[i][k]);
            }
            System.out.println();
        }
    }

    // иницилизация сетки значениями из входных данных
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

    // заполнение выходного массива символов данными из сетки
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

    // метод отображения объекта Cell в символы
    public static char cellToChar(@NotNull Cell cell) {
        boolean isLive = cell.getIsLive();
        if (isLive) {
            return '*';
        } else {
            return '.';
        }

    }


    // метод отображения символа в объект Cell
    public static Cell charToCell(char symbol, int column, int row) {
        if (symbol == '*') {
            return Cell.createLive(column, row);
        } else {
            return Cell.createDead(column, row);
        }

    }

    //Новое поколение сетки
    public static Cell[][] generationalChange(Cell[][] prevGenerationGrid) {
        Cell[][] grid = prevGenerationGrid.clone();
        grid = calculateLiveNeighboursForAll(grid);
        Cell[][] nextGenerationGrid = new Cell[columnAmount][rowAmount];
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[i].length; k++) {
                // цикл по всем точкам сетки
                Cell cell = grid[i][k];
                int column = cell.getColumn();
                int row = cell.getRow();
                if (!isSameNextGeneration(cell)) {
                    if (isDeadNextGeneration(cell)) {
                        nextGenerationGrid[i][k] = Cell.createDead(column, row);
                    } else {
                        nextGenerationGrid[i][k] = Cell.createLive(column, row);
                    }
                } else {
                    if(isLiveNextGeneration(cell)){
                        nextGenerationGrid[i][k] = Cell.createLive(column, row);
                    }else{
                        nextGenerationGrid[i][k] = Cell.createSame(cell);
                    }
                }
            }
        }
        return nextGenerationGrid;
    }

    //Подсчет кол-ва соседей для всех точек
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


    //будет ли "Мертва" в следующем поколении
    public static boolean isDeadNextGeneration(Cell cell) {
        int liveNeighbours = cell.getLiveNeighbours();
        if (liveNeighbours > 3 || liveNeighbours < 2) {
            return true;
        } else {
            return false;
        }
    }
   //будет ли "Жива" в следующем поколении
    public static boolean isLiveNextGeneration(Cell cell) {
        int liveNeighbours = cell.getLiveNeighbours();
        if (liveNeighbours == 3) {
            return true;
        } else {
            return false;
        }
    }
    // Здесь ошибка
    // оставляем в том же состоянии, в котором была
    public static boolean isSameNextGeneration(Cell cell) {
        int liveNeighbours = cell.getLiveNeighbours();
        if (liveNeighbours == 2 || liveNeighbours == 3) {
            return true;
        } else {
            return false;
        }
    }

    //Подсчет кол-ва соседей для конкретной точки
    public static int calculateLiveNeighbours(Cell cell, Cell[][] grid) {
        int[][] neigbourPoints = generateNeighbourPoints(cell);
        int liveNeighbours = 0;
        //цикл по точкам соседей
        for (int i = 0; i < neigbourPoints.length; i++) {
            int neigbourColumn = neigbourPoints[i][0];
            int neigbourRow = neigbourPoints[i][1];
            if (isValidPoints(neigbourColumn, neigbourRow)) {
                Cell neigbour = grid[neigbourColumn][neigbourRow];
                if (isLiveNeighbour(neigbour)) {
                    liveNeighbours++;
                }
            }
        }
        return liveNeighbours;
    }

    // generate Neighbour Points
    public static int[][] generateNeighbourPoints(@NotNull Cell cell) {
        int row = cell.getRow();
        int column = cell.getColumn();
        // 8 - count neigbours of point for two dimensional grid
        int[][] neigbours = new int[8][2];

        //upper line
        neigbours[0] = new int[]{column - 1, row - 1};
        neigbours[1] = new int[]{column, row - 1};
        neigbours[2] = new int[]{column + 1, row - 1};

        //right column
        neigbours[3] = new int[]{column + 1, row};
        neigbours[4] = new int[]{column + 1, row + 1};

        // bottom line
        neigbours[5] = new int[]{column, row + 1};
        neigbours[6] = new int[]{column - 1, row + 1};

        //left line
        neigbours[7] = new int[]{column - 1, row};

        return neigbours;
    }


    /**
     * проверка что сосед живой
     */
    public static boolean isLiveNeighbour(@NotNull Cell cell) {
        return cell.getIsLive();
    }

    // проверка, что точки находятся в границах поля
    public static boolean isValidPoints(int column, int row) {
        if (isValidColumn(column) && isValidRow(row)) {
            return true;
        } else {
            return false;
        }
    }


    @Contract(pure = true)
    public static boolean isValidColumn(int column) {
        if (column < columnAmount && column >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Contract(pure = true)
    public static boolean isValidRow(int row) {
        if (row < rowAmount && row >= 0) {
            return true;
        } else {
            return false;
        }
    }

}
