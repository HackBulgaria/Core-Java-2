package com.hackbulgaria.corejava;

public class FaultyProblem1 {
    public long getLargestPalindrome(long N) {
        N--;
        if (Utils.isPalindrome(N)) {
            return N;
        } else {
            // The function was called with decremented value
            return getLargestPalindrome(N);
        }
    }

}
