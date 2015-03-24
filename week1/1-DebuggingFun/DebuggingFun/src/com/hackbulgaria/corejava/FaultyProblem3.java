package com.hackbulgaria.corejava;

public class FaultyProblem3 {
    
    public String reverseEveryWordInString(String sentence){
        String[] words = sentence.split(" ");
        StringBuilder new_sentence = new StringBuilder();
        for (String word: words){
            new_sentence.append(reverse(word) + " ");
        }
        return new_sentence.substring(0,new_sentence.length()-1).toString();
    }

    private CharSequence reverse(String word) {
        return Utils.reverseMe(word);
    }
}
