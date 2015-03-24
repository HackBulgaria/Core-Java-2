package com.hackbulgaria.corejava;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FaultyProblem3Test {

    private FaultyProblem3 faultyProblem3;

    @Before
    public void setUp() {
        this.faultyProblem3 = new FaultyProblem3();
    }

    @Test
    public void test() {
        assertEquals("gnikrow", faultyProblem3.reverseEveryWordInString("working"));
        assertEquals("tahw dluoc", faultyProblem3.reverseEveryWordInString("what could"));
        /*
         * При извикването на теста се получава следния проблем - тъй като функцията replace-ва обърнатите стрингове
         * във вече съществуващия стринг, който е основният параметър е възможно да промени дума, която съществува.
         * както става с дуамта "is" която се променя на първата и втората дума и след това, когато преминем и променяме
         * втората дума this, тя вече е thsi. За да прескочим този проблем просто чистим стринга и го пълним наново с интервали между новите думи.
         * 
         */
        assertEquals("si siht laer efil", faultyProblem3.reverseEveryWordInString("is this real life"));
    }

}
