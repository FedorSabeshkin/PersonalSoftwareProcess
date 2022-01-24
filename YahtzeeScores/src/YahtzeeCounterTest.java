
import static org.junit.Assert.*;
import org.junit.Test;

public class YahtzeeCounterTest {

    @Test
    public void Count_Ones_3() {
        assertEquals(
                3,
                YahtzeeCounter.count("ones", new int[]{1,2,1,1,5}));
    }

    @Test
    public void Count_Ones_5() {
        assertEquals(
                5,
                YahtzeeCounter.count("ones", new int[]{1,1,1,1,1}));
    }

    @Test
    public void Count_Ones_0() {
        assertEquals(
                0,
                YahtzeeCounter.count("ones", new int[]{3,2,3,2,3}));
    }

    @Test
    public void Count_Twos_4() {
        assertEquals(
                4,
                YahtzeeCounter.count("twos", new int[]{3,2,3,2,3}));
    }

    @Test
    public void Count_Threes_3() {
        assertEquals(
                3,
                YahtzeeCounter.count("threes", new int[]{1,1,1,1,3}));
    }

    @Test
    public void Count_Fives_0() {
        assertEquals(
                0,
                YahtzeeCounter.count("fives", new int[]{3,2,3,2,3}));
    }

    @Test
    public void Count_Fours_16() {
        assertEquals(
                16,
                YahtzeeCounter.count("fours", new int[]{4,2,4,4,4}));
    }

    @Test
    public void Count_Fives_5() {
        assertEquals(
                5,
                YahtzeeCounter.count("fives", new int[]{5,2,3,2,3}));
    }

    @Test
    public void Count_Fives_10() {
        assertEquals(
                10,
                YahtzeeCounter.count("fives", new int[]{5,5,3,2,3}));
    }

    @Test
    public void Count_Fives_25() {
        assertEquals(
                25,
                YahtzeeCounter.count("fives", new int[]{5,5,5,5,5}));
    }

    @Test
    public void Count_Sixes_6() {
        assertEquals(
                6,
                YahtzeeCounter.count("sixes", new int[]{6,2,3,2,3}));
    }



    @Test
    public void Count_Chance_5() {
        assertEquals(
                5,
                YahtzeeCounter.count("chance", new int[]{1,1,1,1,1}));
    }

}
