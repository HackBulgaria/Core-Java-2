package com.hackbulgaria.corejava;


public class FaultyProblem5 {
    public static long kthFac(int k, int n) {
        long res = 1;
        long limit = n;
        for (long i = 2; i <= limit; i++) {
            res *= i;
            if (i == limit && k > 0) {
                k--;
                limit = res;
            }
        }
        return res;
    }
    
}
