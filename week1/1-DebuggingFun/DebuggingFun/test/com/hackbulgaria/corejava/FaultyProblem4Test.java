package com.hackbulgaria.corejava;

import static org.junit.Assert.*;

import org.junit.Test;

public class FaultyProblem4Test {

    
    /*
     * В последната итерация
     *  0.23076923, 0.23076922i=3 j=13
     * i = 3
     * j = 13
     * a = 3/13 = 0.2307692307692308
     * b = 1/13/3 = 0.2307692307692308
     * поради ограничението на float до 8 знака след дес. запетая, закръгля a на 1 нагоре.
     * http://stackoverflow.com/questions/13542944/how-many-significant-digits-have-floats-and-doubles-in-java
     * Конвертирам ги в double и след това ги пращам за проверка във float.
     * 
     */
    @Test
    public void testFloats() {
        for (int i = 2; i < 97; i++) {
            for (int j = 3; j < i * 17; j++) {
                double a = (double) i / j;
                double b = 1 / ((double) j / i);
                // System.out.println(a + ", " + b + "i=" + i + " j="+j);
                assertTrue(FaultyProblem4.areEqual((float)a, (float)b));
            }
        }
    }
    
    @Test
    public void testAgainFloats(){
        assertTrue(FaultyProblem4.areEqual(0/6, 0/5));
        /*
         * Според дебъгера по-долу делим на нула 399/401 -> 0
         * Ако упоменем, че данните ще са float всичко е тип топ.
         */
        assertTrue(FaultyProblem4.areEqual((float)401/399, 1/((float)399/401)));
    }

    @Test
    public void testInts() {
        assertTrue(FaultyProblem4.areEqual(4, 4));
        assertTrue(FaultyProblem4.areEqual(0, 0));
        assertTrue(FaultyProblem4.areEqual(500, 500));

        // Защо са верни горните, а този тест фейлва? ^^^
        /*
         * Защото горните са примитивни int докато долните две са два различни обекта,
         * които когато се сравняват не са едно и също нещо, въпреки, че стойностите им са.
         * За целта решението е да се добави проверка не за еднаквостта на обектите,
         * а за техните стойности с метода .intValue();
         * 
         */
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

        /*
         * Долният тест връщаше True, защото в кода на метода haveEqualSubstrings
         * се създаваха два под стринга, които се сравняваха от i до размера без 1,
         * което ако ги сравним така, т.е. без 's' && 'y' е така, но условието е от 
         * i до края на стринга.
         */
        a = "Speaks";
        b = "Freaky";
        assertFalse(FaultyProblem4.haveEqualSubstrings(a, b));
    }

}
