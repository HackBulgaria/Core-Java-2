package com.hackbulgaria.corejava;

import static org.junit.Assert.*;

import org.junit.Test;

public class FaultyProblem5Test {

    @Test
    public void test() {
        assertEquals(1, FaultyProblem5.kthFac(0, 1));
        
        assertEquals(2, FaultyProblem5.kthFac(1, 2));
        
        assertEquals(720, FaultyProblem5.kthFac(2, 3));
    }

}
