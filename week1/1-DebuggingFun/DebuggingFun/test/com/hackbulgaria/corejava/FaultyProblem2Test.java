package com.hackbulgaria.corejava;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FaultyProblem2Test {

    private FaultyProblem2 faultyProblem2;

    @Before
    public void setUp() {
        this.faultyProblem2 = new FaultyProblem2();
    }
    
    @Test
    public void test() {
        assertEquals(128, faultyProblem2.getNearestPowerOf2(129));
        assertEquals(128, faultyProblem2.getNearestPowerOf2(240));
        assertEquals(2, faultyProblem2.getNearestPowerOf2(2));
        assertEquals(16, faultyProblem2.getNearestPowerOf2(20));
        assertEquals(1, faultyProblem2.getNearestPowerOf2(1));
    }

}
