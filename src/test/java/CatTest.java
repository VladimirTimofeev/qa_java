import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        String actualsSound = cat.getSound();
        assertEquals("Мяу", actualsSound);
    }



    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(Collections.singletonList("Хищник"));
        List<String> expectedEatMeat =  cat.getFood();
        List<String> actualEatMeat = List.of("Хищник");
        assertEquals(expectedEatMeat, actualEatMeat);
    }

}
