package com.hackbulgaria.corejava;

public class FaultyProblem6 {
    public static long pow(int a, int b) {
        if (b == 1){
            return a;
        }
        if (b % 2 == 1) {
            return a * pow(a, b - 1);
        } else {
            long power = pow(a, b / 2);
            return power * power;
        }
    }
}
