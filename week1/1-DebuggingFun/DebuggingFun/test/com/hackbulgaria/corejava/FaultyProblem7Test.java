package com.hackbulgaria.corejava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FaultyProblem7Test {

    @Test
    public void test() {
//        Code code = new Code("System.out.println(\"Hello World\");");
//        Utils.eval(code, "Eval");
        
        /*
         * Проблемът на тази задача бе след като се намери в коя половина би трябвало да
         * се намира елемента и се сложат началото и края на по масива, не се сетваше неговата нова среда.
         */
        assertEquals(2, FaultyProblem7.binarySearch(3, 1, 2, 3, 4, 5, 6, 7, 8));
        assertEquals(7, FaultyProblem7.binarySearch(8, 1, 2, 3, 4, 5, 6, 7, 8));
        assertEquals(0, FaultyProblem7.binarySearch(1, 1, 2, 3, 4, 5, 6, 7, 8));
        assertEquals(-1, FaultyProblem7.binarySearch(9, 1, 2, 3, 4, 5, 6, 7, 8));
    
        
    }

}
