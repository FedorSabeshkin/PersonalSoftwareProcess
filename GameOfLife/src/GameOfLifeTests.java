import static org.junit.Assert.*;
import org.junit.Test;

public class GameOfLifeTests {

    @Test
    public void isDeadNextGeneration_False() {
        Cell liveCell= Cell.createLive(0,0);
        liveCell.setLiveNeighbours(3);
        boolean isDeadNextGeneration = GameOfLife.isDeadNextGeneration(liveCell);
        assertEquals(
                false,isDeadNextGeneration);
    }

    @Test
    public void isDeadNextGeneration_True() {
        Cell liveCell= Cell.createLive(0,0);
        liveCell.setLiveNeighbours(4);
        boolean isDeadNextGeneration = GameOfLife.isDeadNextGeneration(liveCell);
        assertEquals(
                true,isDeadNextGeneration);
    }

    @Test
    public void getIsLive_True() {
        Cell liveCell= Cell.createLive(0,0);
        liveCell.getIsLive();
        assertEquals(
                true,liveCell.getIsLive());
    }

    @Test
    public void getIsLive_False() {
        Cell deadCell= Cell.createDead(0,0);
        deadCell.getIsLive();
        assertEquals(
                false,deadCell.getIsLive());
    }

    @Test
    public void createSame_Is_Live_True() {
        Cell liveCell= Cell.createLive(0,0);
        Cell sameCell = Cell.createSame(liveCell);
        assertEquals(
                liveCell.getIsLive(),sameCell.getIsLive());
    }

    @Test
    public void createSame_Is_Live_False() {
        Cell deadCell= Cell.createDead(0,0);
        Cell sameCell = Cell.createSame(deadCell);
        assertEquals(
                deadCell.getIsLive(),sameCell.getIsLive());
    }


    @Test
    public void isSameNextGeneration_False() {
        Cell liveCell= Cell.createLive(0,0);
        liveCell.setLiveNeighbours(1);
        boolean isSameNextGeneration = GameOfLife.isSameNextGeneration(liveCell);
        assertEquals(
                false,isSameNextGeneration);
    }

    @Test
    public void isSameNextGeneration_Many_Alive_Cells_False() {
        Cell liveCell= Cell.createLive(0,0);
        liveCell.setLiveNeighbours(4);
        boolean isSameNextGeneration = GameOfLife.isSameNextGeneration(liveCell);
        assertEquals(
                false, isSameNextGeneration);
    }

    @Test
    public void isSameNextGeneration_True() {
        Cell liveCell= Cell.createLive(0,0);
        liveCell.setLiveNeighbours(3);
        boolean isSameNextGeneration = GameOfLife.isSameNextGeneration(liveCell);
        assertEquals(
                true, isSameNextGeneration);
    }

}
