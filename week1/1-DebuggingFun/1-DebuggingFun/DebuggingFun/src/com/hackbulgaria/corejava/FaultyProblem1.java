package com.hackbulgaria.corejava;

public class FaultyProblem1 {
    public static long getLargestPalindrome(long N) {
        N--;
        if (Utils.isPalindrome(N)) {
            return N;
        } else {
            return getLargestPalindrome(N);
        }
        
    }
    public static void main(String[] args) {
       FaultyProblem1 n= new FaultyProblem1();
       System.out.println(n.getLargestPalindrome(125));

    }
}
