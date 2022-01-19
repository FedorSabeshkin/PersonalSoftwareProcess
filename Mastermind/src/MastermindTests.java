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
}
