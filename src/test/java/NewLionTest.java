import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class NewLionTest {

    @Test
    public void getKittensTest() throws Exception {
        int actualKitten = 1;
        Feline feline1 = Mockito.mock(Feline.class);
        Mockito.when(feline1.getKittens()).thenReturn(actualKitten);
        Lion lion = new Lion(feline1, "Самка");
        int expectedKittens = lion.getKittens();
        assertEquals(actualKitten, expectedKittens);
    }

    @Test
    public void getFoodTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getFood("Хищник")).thenReturn(Collections.singletonList("Хищник"));
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedFood = lion.getFood();
        List<String> actualFood = List.of("Хищник");
        assertEquals(actualFood, expectedFood);
    }

}
