
import static org.junit.Assert.*;
import org.junit.Test;

public class YahtzeeCounterTest {
    

    @Test
    public void Count_Chance_5() {
        assertEquals(
                5,
                YahtzeeCounter.count("chance", new int[]{1,1,1,1,1}));
    }

}
