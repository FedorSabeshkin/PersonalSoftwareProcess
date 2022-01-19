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
}
