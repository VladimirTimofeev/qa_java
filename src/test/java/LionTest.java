import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {
    private final String SEX;
    private final boolean HASMANERESULT;

    @Mock
    static Feline feline;


    public LionTest(Feline feline, String sex, boolean hasManeResult) {
        SEX = sex;
        HASMANERESULT = hasManeResult;

    }


    @Parameterized.Parameters
    public static Object[][] getDataOrder() {
    return new Object[][] {
            {feline, "Самец", true},
            {feline, "Самка", false},
//            {feline, "Самка", true},
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, SEX);
        boolean sexVariable = lion.doesHaveMane();
        assertEquals(HASMANERESULT, sexVariable);
    }

    @Test
    public void getKittensTest() throws Exception {
        int actualKitten = 1;
        Feline feline1 = Mockito.mock(Feline.class);
        Mockito.when(feline1.getKittens()).thenReturn(actualKitten);
        Lion lion = new Lion(feline1, SEX);
        int expectedKittens = lion.getKittens();
        assertEquals(actualKitten, expectedKittens);
    }

    @Test
    public void getFoodTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getFood("Хищник")).thenReturn(Collections.singletonList("Хищник"));
        Lion lion = new Lion(feline, SEX);
        List<String> expectedFood = lion.getFood();
        List<String> actualFood = List.of("Хищник");
        assertEquals(actualFood, expectedFood);
    }
}