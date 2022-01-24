import static org.junit.Assert.*;
import org.junit.Test;
public class OnePairTest {
    @Test
    public void Count_OnePair_Sixes_12() {
        assertEquals(
                12,
                YahtzeeCounter.count("onePair", new int[]{6,6,1,6,6}));
    }

    @Test
    public void Count_OnePair_Fours_8() {
        assertEquals(
                8,
                YahtzeeCounter.count("onePair", new int[]{4,4,1,3,2}));
    }

    @Test
    public void Count_OnePair_Two_Diff_Pairs_0() {
        assertEquals(
                12,
                YahtzeeCounter.count("onePair", new int[]{2,2,1,6,6}));
    }

}
