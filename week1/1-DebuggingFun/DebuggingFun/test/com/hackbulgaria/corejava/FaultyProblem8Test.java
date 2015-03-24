package com.hackbulgaria.corejava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FaultyProblem8Test {

    @Test
    public void test() {

        assertEquals(4, FaultyProblem8.getNumberOfDigits(1000));
        assertEquals(4, FaultyProblem8.getNumberOfDigits(9999));
        assertEquals(9, FaultyProblem8.getNumberOfDigits(123423411));
        // assertEquals(3, FaultyProblem8.getNumberOfDigits(000));        
        assertEquals(6, FaultyProblem8.getNumberOfDigits(123.321));
        assertEquals(5, FaultyProblem8.getNumberOfDigits("12345"));
        assertEquals(2, FaultyProblem8.getNumberOfDigits("0.2"));
    }

}
