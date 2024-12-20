import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametersTest {
    private final String SEX;
    private final boolean HASMANERESULT;

    @Mock
    static Feline feline;


    public LionParametersTest(Feline feline, String sex, boolean hasManeResult) {
        SEX = sex;
        HASMANERESULT = hasManeResult;

    }


    @Parameterized.Parameters
    public static Object[][] getDataOrder() {
    return new Object[][] {
            {feline, "Самец", true},
            {feline, "Самка", false},
            {feline, "Самка", true},
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, SEX);
        boolean sexVariable = lion.doesHaveMane();
        assertEquals(HASMANERESULT, sexVariable);
    }
}