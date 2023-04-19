package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {

    @Mock
    Feline feline;
    String sex;
    boolean expHasMane;

    public LionTest(String sex,boolean expHasMane) {
        this.sex = sex;
        this.expHasMane = expHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {"Самец",true},
                {"Самка",false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = Exception.class)
    public void LionTestWithUndefinedSex() throws Exception {
        new Lion("Конь в пальто", feline);
    }
    @Test
    public void getKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(2);
        int expResult = 2;
        Lion lion = new Lion(sex, feline);
        int actResult = lion.getKittens();
        assertEquals(expResult, actResult);
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actResul = lion.doesHaveMane();
        boolean expResult = expHasMane;
        assertEquals(expResult, actResul);
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(sex,feline);
        lion.getFood();
        Mockito.verify(feline,Mockito.times(1)).getFood("Хищник");
    }
}