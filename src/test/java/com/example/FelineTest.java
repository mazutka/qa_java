package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;
    @Test
    public void eatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamily() {
        String expResult = "Кошачьи";
        String actResult = feline.getFamily();
        assertEquals(expResult,actResult);
    }

    @Test
    public void getKittensWithOutParams() {
        feline.getKittens();
        Mockito.verify(feline,Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensWithParams() {
        int expResult = 5;
        int actResult = feline.getKittens(5);
        assertEquals(expResult,actResult);
    }
}