import static org.junit.Assert.*;
import org.junit.Test;

public class ThreeOfKindTest {

    @Test
    public void Count_ThreeOfKind_Two_Diff_Pairs_0() {
        assertEquals(
                0,
                YahtzeeCounter.count("threeOfKind", new int[]{4,4,1,6,6}));
    }

    @Test
    public void Count_ThreeOfKind_12() {
        assertEquals(
                0,
                YahtzeeCounter.count("threeOfKind", new int[]{4,4,4,5,5}));
    }
}
