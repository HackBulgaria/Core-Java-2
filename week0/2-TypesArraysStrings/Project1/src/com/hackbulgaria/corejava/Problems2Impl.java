package com.hackbulgaria.corejava;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int number) {
    	 return number%2!=0 ? true : false;
    }

    @Override
    public boolean isPrime(int number) {
    	for(int i=2;2*i<number;i++) {
            if(number%i==0)
                return false;
        }
        return true;
    }

    @Override
    public int min(int... array) {
    	int min= array[0];
        for(int i=0; i<array.length; i++){
            if(array[i]<min){
                min=array[i];
            }
        }
        return min;
    }

    @Override
    public int kthMin(int k, int[] array) {
    	Arrays.sort(array);
        return array[k-1];
    }

    @Override
    public float getAverage(int[] array) {
    	float avg = 0;
        for (int i = 0; i < array.length; i++) {
            avg += array[i];
        }
        avg /= array.length;
        return avg;
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long getLargestPalindrome(long N) {
        if(N<10){
        	return N;
        }
    	for (long i = N; i >= 11; i--) {
			String number = Long.toString(i);
			if(this.isPalindrome(number))
				return i;
		}
	
    	return N;
    }

    @Override
    public int[] histogram(short[][] image) {
		int[] result = new int[256];
        
        for (int row = 0; row < image.length; row++) {
            for (int col = 0; col < image[0].length; col++) {
                result[image[row][col]]++;
            }
        }
        
        return result;
    }

    @Override
    public long doubleFac(int n) {
        return fac((int)fac(n));
    }
    
    private long fac(int n){
    	 long result = 1;
         for(int i=1; i<=n;i++){
             result*=i;
         }
         return result;
    }

    @Override
    public long kthFac(int k, int n) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getOddOccurrence(int[] array) {
    	int result = 0;

        for (int i = 0; i < array.length; i++) {
        	result = result ^ array[i];

        }
        return result;
    }

    @Override
    public long pow(int a, int b) {
        return (long) Math.pow(a, b);
    }

    @Override
    public long maximalScalarSum(int[] a, int[] b) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int maxSpan(int[] array) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean canBalance(int[] array) {
        long leftSum=0;
        long rightSum=0;
        int length = array.length;
        for (int i = 0; i < length/2; i++) {
			leftSum+=array[i];
			rightSum+=array[length-i-1];
		}
        
        if(length%2!=0){
        	leftSum+=array[length%2];
        }
        
        return leftSum==rightSum;
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String reverseMe(String argument) {
    	return new StringBuilder(argument).reverse().toString();
    }

    @Override
    public String copyEveryChar(String input, int k) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < k; j++) {
				result.append(input.charAt(i));
			}
		}
        
        return result.toString();
    }

    @Override
    public String reverseEveryWord(String arg) {
        String[] words = arg.split(" ");
        
        for (int i = 0; i < words.length; i++) {
			words[i] = this.reverseMe(words[i]);
		}
        
        return String.join(" ", words);
    }

    @Override
    public boolean isPalindrome(String argument) {
    	int length = argument.length();
    	
    	for (int j = 0; j < length/2; j++) {
			if(argument.charAt(j)!=argument.charAt(length - j - 1)){
				return false;
			}
		}
    	
    	return true;
    }

    @Override
    public boolean isPalindrome(int number) {
        return this.isPalindrome(Integer.toString(number));
    }

    @Override
    public int getPalindromeLength(String input) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
    	return haystack.split(Pattern.quote(needle), -1).length - 1;
    }

    @Override
    public String decodeURL(String input) {
    	input = input.replaceAll("%20", "");
        input = input.replaceAll("%3A", ":");
        input = input.replaceAll("%3D", "?");
        input = input.replaceAll("%2F", "/");
        
        return input;
    }

    @Override
    public int sumOfNumbers(String input) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean areAnagrams(String A, String B) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasAnagramOf(String string, String string2) {
        // TODO Auto-generated method stub
        return false;
    }

}
