import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {


    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> expectedGetFood = feline.eatMeat();
        List<String> actualGetFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(actualGetFood, expectedGetFood);
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        String name = feline.getFamily();
        assertEquals("Кошачьи", name);
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        int expectedCount = feline.getKittens();
        assertEquals(1, expectedCount);
    }

    @Test
    public void getKittensIntTest() {
        int actualCount = 2;
        Feline feline = new Feline();
        int expectedCount = feline.getKittens(actualCount);
        assertEquals(actualCount, expectedCount);
    }
}
