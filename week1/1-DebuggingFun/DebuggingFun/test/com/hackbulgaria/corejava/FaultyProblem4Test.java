package com.hackbulgaria.corejava;

import static org.junit.Assert.*;

import org.junit.Test;

public class FaultyProblem4Test {

    @Test
    public void testFloats() {
        for (int i = 2; i < 97; i++) {
            for (int j = 3; j < i * 17; j++) {
                float a = (float) i / j;
                float b = 1 / ((float) j / i);
                System.out.println(a + ", " + b);
                assertTrue(FaultyProblem4.areEqual(a, b));
            }
        }
    }
    
    @Test
    public void testAgainFloats(){
        assertTrue(FaultyProblem4.areEqual(0/6, 0/5));
        assertTrue(FaultyProblem4.areEqual(401/399, 1/(399/401)));
    }

    @Test
    public void testInts() {
        assertTrue(FaultyProblem4.areEqual(4, 4));
        assertTrue(FaultyProblem4.areEqual(0, 0));
        assertTrue(FaultyProblem4.areEqual(500, 500));

        // Защо са верни горните, а този тест фейлва? ^^^
        assertTrue(FaultyProblem4.areEqual(new Integer(511), (Integer) 511));
    }
    
    @Test
    public void testSubstringEquality() throws Exception {
        String a = "how do you do";
        String b = "how do you do";
        
        assertTrue(FaultyProblem4.haveEqualSubstrings(a, b));

        a = "Bearded Man";
        b = "Non-bearded Man";
        assertFalse(FaultyProblem4.haveEqualSubstrings(a, b));

        a = "Speaks";
        b = "Freaky";
        assertFalse(FaultyProblem4.haveEqualSubstrings(a, b));
    }

}
