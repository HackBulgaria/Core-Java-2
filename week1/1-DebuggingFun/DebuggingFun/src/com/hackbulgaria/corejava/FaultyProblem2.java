package com.hackbulgaria.corejava;

public class FaultyProblem2 {

    public int getNearestPowerOf2(int x) {
        int i = 0;
        while (x != 1) {
            x /= 2;
            i++;
        }

        return (int) Math.pow(2, i);
    }
    
    
    

}
