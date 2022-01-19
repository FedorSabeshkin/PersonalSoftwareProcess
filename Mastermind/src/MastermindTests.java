import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.*;

public class MastermindTests {

    @Test
    public void checkColorExist_True() {
        assertTrue(Mastermind.checkColorExist("blue", new String[] {"blue","yellow","black"}));
    }

    @Test
    public void checkColorExist_False() {
        assertFalse(Mastermind.checkColorExist("red", new String[] {"blue","yellow","black"}));
    }

    @Test
    public void checkColorExist_Last_Item_True() {
        assertTrue(Mastermind.checkColorExist("black", new String[] {"blue","yellow","black"}));
    }

    @Test
    public void countSamePositionColors_1() {
        assertEquals(1,
                Mastermind.countSamePositionColors(
                new String[] {"red","blue","orange"},
                new String[] {"yellow","blue","black"}));
    }

    @Test
    public void countSamePositionColors_0() {
        assertEquals(0,
                Mastermind.countSamePositionColors(
                new String[] {"red","blue","orange"},
                new String[] {"green","yellow","black"}));
    }

    @Test
    public void countSamePositionColors_3() {
        assertEquals(3,
                Mastermind.countSamePositionColors(
                new String[] {"red","blue","orange"},
                new String[] {"red","blue","orange"}));
    }

    @Test
    public void countSameColors_1() {
        assertEquals(1,
                Mastermind.countSameColors(
                        new String[] {"red","blue","orange"},
                        new String[] {"blue","yellow","black"}));
    }

    @Test
    public void countSameColors_3() {
        assertEquals(3,
                Mastermind.countSameColors(
                        new String[] {"red","blue","orange"},
                        new String[] {"orange","blue","red"}));
    }

    @Test
    public void countSameColors__In_Same_Positions_3() {
        assertEquals(3,
                Mastermind.countSameColors(
                        new String[] {"red","blue","orange"},
                        new String[] {"red","blue","orange"}));
    }

    @Test
    public void countSameColors_0() {
        assertEquals(0,
                Mastermind.countSameColors(
                        new String[] {"red","blue","orange"},
                        new String[] {"green","yellow","black"}));
    }

    @Test
    public void countNonSamePositionsColors_1() {
        assertEquals(1,
                Mastermind.countNonSamePositionsColors(
                        new String[] {"red","blue","orange"},
                        new String[] {"blue","yellow","black"}));
    }

    @Test
    public void countNonSamePositionsColors_2() {
        assertEquals(2,
                Mastermind.countNonSamePositionsColors(
                        new String[] {"red","blue","orange"},
                        new String[] {"orange","blue","red"}));
    }

    @Test
    public void countNonSamePositionsColors_All_Colors_Same_Positions_0() {
        assertEquals(0,
                Mastermind.countNonSamePositionsColors(
                        new String[] {"red","blue","orange"},
                        new String[] {"red","blue","orange"}));
    }

    @Test
    public void countNonSamePositionsColors_0() {
        assertEquals(0,
                Mastermind.countNonSamePositionsColors(
                        new String[] {"red","blue","orange"},
                        new String[] {"green","yellow","black"}));
    }

    @Test
    public void gameMove_SamePositions_0_SameColors_0() {
        assertArrayEquals(new int[] {0,0},
                Mastermind.gameMove(
                        new String[] {"red","blue","orange"},
                        new String[] {"green","yellow","black"}));
    }

    @Test
    public void gameMove_SamePositions_3_SameColors_0() {
        assertArrayEquals(new int[] {3,0},
                Mastermind.gameMove(
                        new String[] {"red","blue","orange"},
                        new String[] {"red","blue","orange"}));
    }

    @Test
    public void gameMove_SamePositions_1_SameColors_2() {
        assertArrayEquals(new int[] {1,2},
                Mastermind.gameMove(
                        new String[] {"red","blue","orange"},
                        new String[] {"orange","blue","red"}));
    }

    @Test
    public void gameMove_SamePositions_0_SameColors_3() {
        assertArrayEquals(new int[] {0,3},
                Mastermind.gameMove(
                        new String[] {"red","blue","orange"},
                        new String[] {"blue","orange","red"}));
    }
}
