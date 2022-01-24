import static org.junit.Assert.*;
import org.junit.Test;

public class LargeStraightTest {

    @Test
    public void Count_LargeStraight_40() {
        assertEquals(
                40,
                YahtzeeCounter.count("largeStraight", new int[]{1,2,3,4,5}));
    }

    @Test
    public void Count_LargeStraight_From_Two_40() {
        assertEquals(
                40,
                YahtzeeCounter.count("largeStraight", new int[]{2,3,4,5,6}));
    }

    @Test
    public void Count_LargeStraight_0() {
        assertEquals(
                0,
                YahtzeeCounter.count("largeStraight", new int[]{1,4,3,4,1}));
    }
}
