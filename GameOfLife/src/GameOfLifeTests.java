import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.*;

public class GameOfLifeTests {

    char[][] chars = {
            {'.', '.', '.', '.', '.'},
            {'.', '.', '*', '.', '.'},
            {'.', '*', '*', '.', '.'},
            {'.', '.', '.', '.', '.'}
    };
    Cell[][] prevGenerationGrid = GameOfLife.charGridToCellGrid(chars);




    @Test
    public void calculateLiveNeighboursForAll_For_1_2_Will_2() {

        prevGenerationGrid = GameOfLife.calculateLiveNeighboursForAll(prevGenerationGrid);
        Cell deadCell = prevGenerationGrid[1][2];
        int liveNeighbours = deadCell.getLiveNeighbours();
        assertEquals(
                2, liveNeighbours);
    }

    @Test
    public void getIsLive_For_1_1_After_Calculate_Neighbours_Will_False() {

        prevGenerationGrid = GameOfLife.calculateLiveNeighboursForAll(prevGenerationGrid);
        Cell cell = prevGenerationGrid[1][1];
        assertEquals(
                false, cell.getIsLive());
    }

    @Test
    public void calculateLiveNeighboursForAll_0() {

        prevGenerationGrid = GameOfLife.calculateLiveNeighboursForAll(prevGenerationGrid);
        Cell deadCell = prevGenerationGrid[0][0];
        int liveNeighbours = deadCell.getLiveNeighbours();
        assertEquals(
                0, liveNeighbours);
    }

    @Test
    public void calculateLiveNeighboursForAll_For_1_1_Will_3() {

        prevGenerationGrid = GameOfLife.calculateLiveNeighboursForAll(prevGenerationGrid);
        Cell deadCell = prevGenerationGrid[1][1];
        int liveNeighbours = deadCell.getLiveNeighbours();
        assertEquals(
                3, liveNeighbours);
    }


    @Test
    public void generationalChange_For_2_1_Will_Dead() {
        char[][] chars_second = {
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '*', '*', '*', '.'},
                {'.', '.', '.', '.', '.'}
        };
        Cell[][] prevGenerationGrid_second = GameOfLife.charGridToCellGrid(chars_second);

        Cell[][] nextGenerationGrid = GameOfLife.generationalChange(prevGenerationGrid_second);
        Cell liveCell = nextGenerationGrid[2][1];
        boolean live = liveCell.getIsLive();
        assertEquals(
                false, live);
    }

    @Test
    public void generationalChange_For_3_2_Will_Dead() {
        char[][] chars_third = {
                {'.', '.', '.', '.', '.'},
                {'.', '.', '*', '.', '.'},
                {'.', '.', '*', '.', '.'},
                {'.', '.', '*', '.', '.'}
        };
        Cell[][] prevGenerationGrid_third = GameOfLife.charGridToCellGrid(chars_third);

        Cell[][] nextGenerationGrid = GameOfLife.generationalChange(prevGenerationGrid_third);
        Cell liveCell = nextGenerationGrid[3][2];
        boolean live = liveCell.getIsLive();
        assertEquals(
                false, live);
    }



    @Test
    public void generationalChange_For_Edge_Of_Grid_1_4_Will_Live() {
        char[][] chars_fourth = {
                {'.', '.', '.', '.', '*'},
                {'.', '.', '.', '.', '*'},
                {'.', '.', '.', '.', '*'},
                {'.', '.', '.', '.', '.'}
        };
        Cell[][] prevGenerationGrid_fourth = GameOfLife.charGridToCellGrid(chars_fourth);

        Cell[][] nextGenerationGrid = GameOfLife.generationalChange(prevGenerationGrid_fourth);
        Cell liveCell = nextGenerationGrid[1][4];
        boolean live = liveCell.getIsLive();
        assertEquals(
                true, live);
    }

    @Test
    public void generationalChange_For_Edge_Of_Grid_2_1_Will_Live() {
        char[][] chars_fifth = {
                {'.', '.', '.', '.', '*'},
                {'*', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '*'},
                {'*', '*', '.', '.', '.'}
        };
        Cell[][] prevGenerationGrid_fifth = GameOfLife.charGridToCellGrid(chars_fifth);

        Cell[][] nextGenerationGrid = GameOfLife.generationalChange(prevGenerationGrid_fifth);
        Cell liveCell = nextGenerationGrid[2][1];
        boolean live = liveCell.getIsLive();
        assertEquals(
                true, live);
    }

    @Test
    public void generationalChange_For_Edge_Of_Grid_2_2_Will_Live() {
        char[][] chars_fifth = {
                {'*', '*', '*', '*', '*'},
                {'*', '.', '.', '.', '*'},
                {'*', '.', '.', '.', '*'},
                {'*', '*', '*', '*', '*'}
        };
        Cell[][] prevGenerationGrid_fifth = GameOfLife.charGridToCellGrid(chars_fifth);

        Cell[][] nextGenerationGrid = GameOfLife.generationalChange(prevGenerationGrid_fifth);
        Cell liveCell = nextGenerationGrid[2][2];
        boolean live = liveCell.getIsLive();
        assertEquals(
                true, live);
    }

    @Test
    public void generationalChange_For_Edge_Of_Grid_Only_Uncles_Will_Live() {
        char[][] chars_fifth = {
                {'*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*'}
        };
        Cell[][] prevGenerationGrid_fifth = GameOfLife.charGridToCellGrid(chars_fifth);

        Cell[][] nextGenerationGrid = GameOfLife.generationalChange(prevGenerationGrid_fifth);
        Cell cellLeftBottom = nextGenerationGrid[3][0];
        Cell cellLeftUp = nextGenerationGrid[0][0];
        Cell cellRightUp = nextGenerationGrid[0][4];
        Cell cellRightBottom = nextGenerationGrid[3][4];

        cellLeftBottom.getIsLive();
        boolean live = cellLeftBottom.getIsLive() && cellLeftUp.getIsLive() && cellRightUp.getIsLive() && cellRightBottom.getIsLive();
        assertEquals(
                true, live);
    }

    @Test
    public void generationalChange_True() {

        Cell[][] nextGenerationGrid = GameOfLife.generationalChange(prevGenerationGrid);
        Cell liveCell = nextGenerationGrid[1][1];
        boolean live = liveCell.getIsLive();
        assertEquals(
                true, live);
    }



    @Test
    public void isDeadNextGeneration_False() {
        Cell liveCell = Cell.createLive(0, 0);
        liveCell.setLiveNeighbours(3);
        boolean isDeadNextGeneration = GameOfLife.isDeadNextGeneration(liveCell);
        assertEquals(
                false, isDeadNextGeneration);
    }

    @Test
    public void isDeadNextGeneration_False_() {
        Cell liveCell = Cell.createLive(0, 0);
        liveCell.setLiveNeighbours(3);
        boolean isDeadNextGeneration = GameOfLife.isDeadNextGeneration(liveCell);
        assertEquals(
                false, isDeadNextGeneration);
    }

    @Test
    public void isDeadNextGeneration_True() {
        Cell liveCell = Cell.createLive(0, 0);
        liveCell.setLiveNeighbours(4);
        boolean isDeadNextGeneration = GameOfLife.isDeadNextGeneration(liveCell);
        assertEquals(
                true, isDeadNextGeneration);
    }

    @Test
    public void getIsLive_True() {
        Cell liveCell = Cell.createLive(0, 0);
        liveCell.getIsLive();
        assertEquals(
                true, liveCell.getIsLive());
    }

    @Test
    public void getIsLive_False() {
        Cell deadCell = Cell.createDead(0, 0);
        deadCell.getIsLive();
        assertEquals(
                false, deadCell.getIsLive());
    }

    @Test
    public void createSame_Is_Live_True() {
        Cell liveCell = Cell.createLive(0, 0);
        Cell sameCell = Cell.createSame(liveCell);
        assertEquals(
                liveCell.getIsLive(), sameCell.getIsLive());
    }

    @Test
    public void createSame_Is_Live_False() {
        Cell deadCell = Cell.createDead(0, 0);
        Cell sameCell = Cell.createSame(deadCell);
        assertEquals(
                deadCell.getIsLive(), sameCell.getIsLive());
    }


    @Test
    public void isSameNextGeneration_False() {
        Cell liveCell = Cell.createLive(0, 0);
        liveCell.setLiveNeighbours(1);
        boolean isSameNextGeneration = GameOfLife.isSameNextGeneration(liveCell);
        assertEquals(
                false, isSameNextGeneration);
    }

    @Test
    public void isSameNextGeneration_Many_Alive_Cells_False() {
        Cell liveCell = Cell.createLive(0, 0);
        liveCell.setLiveNeighbours(4);
        boolean isSameNextGeneration = GameOfLife.isSameNextGeneration(liveCell);
        assertEquals(
                false, isSameNextGeneration);
    }

    @Test
    public void isSameNextGeneration_True() {
        Cell liveCell = Cell.createLive(0, 0);
        liveCell.setLiveNeighbours(3);
        boolean isSameNextGeneration = GameOfLife.isSameNextGeneration(liveCell);
        assertEquals(
                true, isSameNextGeneration);
    }


}
