package com.hackbulgaria.corejava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.net.URI;
import java.net.URISyntaxException;

public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int number) {
        return (number % 2 == 0) ? false : true;
    }

    @Override
    public boolean isPrime(int number) {
        int to = number;
        int from = 0;
        int num = 2;
        Map<Integer, Integer> primes = new HashMap<Integer, Integer>();

        // Each element id eq the value
        for (int i = num; i <= to; i++)
            primes.put(i, i);
        while (num * num < to) {
            for (int i = num; i <= to; i += num) {
                if (i == num) {
                    continue;
                }
                primes.remove(i);
            }

            for (int key : primes.keySet())
                if (key > num) {
                    num = key;
                    break;
                }
        }
        for (int key : primes.keySet()) {
            if (key < from)
                continue;
            to = key;
        }

        return (to == number) ? true : false;
    }

    @Override
    public int min(int... array) {
        int minimal = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            minimal = (array[i] <= minimal) ? array[i] : minimal;
        }
        return minimal;
    }

    @Override
    public int kthMin(int k, int[] arr) {

        int temp;
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] >= arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr[k - 1];
    }

    @Override
    public float getAverage(int[] array) {
        float temp = 0;

        for (int i = 0; i < array.length; i++)
            temp += array[i];

        return temp / array.length;
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
        long result = 1;
        for (int i = 2; i <= upperBound; i++) {
            int[] divisors = getDivisors(i);
            int pointer = 0;
            while (result % i != 0) {
                result *= divisors[pointer++];
            }
        }
        return result;
    }

    private static int[] getDivisors(int number) {
        int[] divisors = new int[number];
        int pointer = 0;
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                divisors[pointer++] = i;
                number /= i;
                i--;
            }
        }
        return divisors;
    }

    @Override
    public long getLargestPalindrome(long N) { 
        for(long i=N-1;i>=9;i--){
            if(isPalindrome(Long.toString(i)))
                return i;
        }
        return 0;
    }

    @Override
    public int[] histogram(short[][] image) {
        int[] hist = {1};
        return hist;
    }

    @Override
    public long doubleFac(int n) {
        long z = n;
        return normalFac(normalFac(z));
    }

    public long normalFac(long n) {
        long z = 1;
        for (long i = 1; i <= n; i++)
            z *= i;
        return z;
    }

    @Override
    public long kthFac(int k, int n) {
        long z = 1;

        // with helper function
        /*
         * for(int i=1;i<=k;i++) z = normalFac(z);
         */
        for (int i = 1; i <= k; i++) {
            for (long j = 1; j <= n; j++)
                z *= j;
        }
        return z;
    }

    @Override
    public int getOddOccurrence(int[] array) {

        int chk[] = new int[1000];
        Arrays.fill(chk, 0);

        for (int i = 0; i < array.length; i++) {
            chk[array[i]]++;
        }

        for (int i = 0; i < chk.length; i++) {
            if (chk[i] % 2 == 1)
                return i;
        }
        return 0;
    }

    @Override
    public long pow(int a, int b) {
        long p = 1;
        for (int i = 1; i <= b; i++)
            p *= a;
        return p;
    }

    @Override
    public long maximalScalarSum(int[] a, int[] b) {

        return 0;
    }

    @Override
    public int maxSpan(int[] array) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean canBalance(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (sumArr(0, i, array) == sumArr(i + 1, array.length, array))
                return true;
        }

        return false;
    }

    public int sumArr(int begin, int end, int[] array) {
        int s = 0;
        if (end >= array.length)
            end = array.length - 1;
        for (int i = begin; i <= end; i++)
            s += array[i];
        return s;
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        // TODO Auto-generated method stub
        return original;
    }

    @Override
    public String reverseMe(String argument) {
        String str = "";
        for (int i = argument.length() - 1; i >= 0; i--) {
            str += argument.charAt(i);
        }
        return str;
    }

    @Override
    public String copyEveryChar(String input, int k) {

        String str = "";
        for (int i = 0; i < input.length(); i++)
            for (int j = 1; j <= k; j++)
                str += input.charAt(i);

        return str;
    }

    @Override
    public String reverseEveryWord(String arg) {

        String[] splited = arg.split("\\s+");
        arg = "";
        for (int i = 0; i < splited.length; i++)
            arg = arg + reverseMe(splited[i]) + " ";

        return arg.substring(0, arg.length() - 1);
    }

    @Override
    public boolean isPalindrome(String argument) {
        int n = argument.length();
        for (int i=0;i<(n / 2) + 1;++i) {
           if (argument.charAt(i) != argument.charAt(n - i - 1)) {
               return false;
           }
        }
        return true;
    }

    @Override
    public boolean isPalindrome(int number) {
        return (number>=0 && number<=9) ? true : isPalindrome(Integer.toString(number));
    }

    @Override
    public int getPalindromeLength(String input) {

        int star_position = 0;
        int pal_size = 0;
        for(int i=0;i<input.length();i++)
            if(input.charAt(i)=='*')
                star_position = i;
        
        if(star_position==0) return 0;

        for(int i=star_position-1;i>=0;i--){
            if (input.charAt(i) != input.charAt(star_position + (star_position-i))) {
                break;
            }
            pal_size++;
        }
        
        return pal_size;
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
        return haystack.split(needle).length - 1;
    }

    @Override
    public String decodeURL(String input) {
        try {
            URI uri = new URI(input);
            return uri.getPath().toString();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public int sumOfNumbers(String input) {
        int sum = 0;
        String num = "";
        boolean minus = false;

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '-') {
                minus = true;
                continue;
            }

            if (Character.isDigit(input.charAt(i))) {
                num = num + input.charAt(i);

                if (i == input.length() - 1)
                    sum = sum + (Integer.parseInt(num) * ((minus) ? -1 : 1));

            } else {
                if (!num.equals("")) {
                    sum = sum + (Integer.parseInt(num) * ((minus) ? -1 : 1));
                    num = "";
                    minus = false;
                }

            }

        }

        return sum;
    }

    @Override
    public boolean areAnagrams(String A, String B) {
        char[] word1 = A.replaceAll("[\\s]", "").toCharArray();
        char[] word2 = B.replaceAll("[\\s]", "").toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        return Arrays.equals(word1, word2);
    }

    @Override
    public boolean hasAnagramOf(String string, String string2) {
        int slen = string.length();

        for(int i=0;i<=string2.length()-slen;i++){
            
            char[] word1 = string.replaceAll("[\\s]", "").toCharArray();
            char[] word2 = string2.substring(i, i+slen).replaceAll("[\\s]", "").toCharArray();

            Arrays.sort(word1);
            Arrays.sort(word2);
            
            if(Arrays.equals(word1, word2)) return true;            
        }
        
        return false;
    }

}