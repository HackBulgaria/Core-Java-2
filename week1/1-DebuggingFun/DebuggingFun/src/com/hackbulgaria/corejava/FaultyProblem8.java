package com.hackbulgaria.corejava;

public class FaultyProblem8 {

    public static int getNumberOfDigits(String s){
        s = s.replaceAll("[^0-9]","");
        return s.length();
    }

    public static int getNumberOfDigits(double n){
        return getNumberOfDigits(String.valueOf(n));
    }
    
    public static int getNumberOfDigits(long n){
        return getNumberOfDigits(String.valueOf(n));
    }    

}
