import static org.junit.Assert.*;
import org.junit.Test;

public class TwoPairTest {

    @Test
    public void Count_TwoPair_Two_Diff_Pairs_20() {
        assertEquals(
                20,
                YahtzeeCounter.count("twoPair", new int[]{4,4,1,6,6}));
    }

    @Test
    public void Count_TwoPair_One_Diff_Pairs_Only_0() {
        assertEquals(
                0,
                YahtzeeCounter.count("twoPair", new int[]{4,4,1,4,4}));
    }
}
