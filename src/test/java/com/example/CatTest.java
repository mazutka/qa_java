package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;
    @Test
    public void getSound() {
        Cat cat = new Cat(null);
        String expResult = "Мяу";
        String actResult = cat.getSound();
        assertEquals(expResult,actResult);
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Мышка", "Бабочка", "Паук"));
        Cat cat = new Cat(feline);
        List<String> expResult = List.of("Мышка", "Бабочка", "Паук");
        List<String> actResult = cat.getFood();
        assertEquals(expResult,actResult);
    }
}