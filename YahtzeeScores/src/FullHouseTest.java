import static org.junit.Assert.*;
import org.junit.Test;

public class FullHouseTest {


    @Test
    public void Count_FullHouse_25() {
        assertEquals(
                25,
                YahtzeeCounter.count("fullHouse", new int[]{3,3,3,2,2}));
    }

    @Test
    public void Count_FullHouse_From_Two_25() {
        assertEquals(
                25,
                YahtzeeCounter.count("fullHouse", new int[]{3,3,2,2,2}));
    }



    @Test
    public void Count_FullHouse_0() {
        assertEquals(
                0,
                YahtzeeCounter.count("fullHouse", new int[]{3,3,3,2,1}));
    }
}
