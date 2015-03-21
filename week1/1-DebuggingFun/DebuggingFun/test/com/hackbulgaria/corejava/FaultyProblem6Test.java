package com.hackbulgaria.corejava;

import static org.junit.Assert.*;

import org.junit.Test;

public class FaultyProblem6Test {

    /*
     * При този тест имахме java.lang.StackOverflowError
     * at com.hackbulgaria.corejava.FaultyProblem6.pow(FaultyProblem6.java:11) ...
     * 
     * Основната прична беше че не проверяваме дали втория параметър е 0, имаше проверка само за 1
     * което вкарваше в безкраен цикъл функцията да се замоизвиква.
     * След добавяне на проверка за частния случай на 0, всичко е тип топ. ;)
     * 
     * 
     */
    @Test
    public void test() {
        assertEquals(1, FaultyProblem6.pow(1, 999999999));
        assertEquals(8, FaultyProblem6.pow(2, 3));
        assertEquals(16, FaultyProblem6.pow(2, 4));
        assertEquals(1, FaultyProblem6.pow(4, 0));
        assertEquals(1, FaultyProblem6.pow(999999999, 0));
    }

}
