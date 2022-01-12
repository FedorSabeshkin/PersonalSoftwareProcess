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

    public void setup() {
        prevGenerationGrid = GameOfLife.charGridToCellGrid(chars);
    }



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

//    @Test
//    public void generationalChange_True() {
//
//        Cell[][] nextGenerationGrid = GameOfLife.generationalChange(prevGenerationGrid);
//        Cell liveCell = nextGenerationGrid[1][1];
//        boolean live = liveCell.getIsLive();
//        assertEquals(
//                true, live);
//    }

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
