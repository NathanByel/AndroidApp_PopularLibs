package ru.nbdev.popularlibs.unit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdderUnitTest {

    private Adder adder;

    @Before
    public void before() {
        adder =  new Adder();
    }

    @Test
    public void addition1_isCorrect() {
        assertEquals(4, adder.add(2, 2));
    }

    @Test
    public void addition2_isCorrect() {
        assertEquals(4, adder.wrongAdd(2, 2));
    }
}
