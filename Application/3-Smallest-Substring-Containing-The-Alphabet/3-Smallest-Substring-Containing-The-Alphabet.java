/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg3.smallest.substring.containing.the.alphabet;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 *
 * @author evlogimi
 */
public class SmallestSubstringContainingTheAlphabet {

    // If t is not set, set it as alphabet ;)
    public static void smallestSubstringContainingTheAlphabet(String s){
        String t = "abcdefghijklmnopqrstuvwxyz";
        smallestSubstringContainingTheAlphabet(s,t);
    }
    
    public static void smallestSubstringContainingTheAlphabet(String s,String t){
        
        int slen = s.length();
        int tlen = t.length();
        
        if(slen+tlen==0 || slen<tlen){
              System.out.println("invalid input");
              return;
        }
        
	int minWindowBegin = 0;
	int minWindowLen = slen;
        int count = 0;
        int hsf[] = new int[256]; 
        Arrays.fill(hsf, 0);
        Map<Character, Integer> nfc = new HashMap<Character, Integer>();
       
           
       for(int i=0;i<tlen;i++){
           if(nfc.get(t.charAt(i)) != null){
               nfc.put(t.charAt(i),nfc.get(t.charAt(i))+1);
           }else nfc.put(t.charAt(i), 1);
       }
       
       
       for(int end=0, begin=0;end<slen;end++){
           
           // skip characters not in searched string t
           if(nfc.get(s.charAt(end))==null){continue;}
           hsf[s.charAt(end)]++;
           if(hsf[s.charAt(end)] <= nfc.get(s.charAt(end))) count++;
           
            // if window constraint is satisfied, not very elegant ;?
           if(count == tlen){
               while(nfc.get(s.charAt(begin)) == null || 
                       hsf[s.charAt(begin)] > nfc.get(s.charAt(begin))){
                        if(nfc.get(s.charAt(begin))!=null){
                            if(hsf[s.charAt(begin)] > nfc.get(s.charAt(begin))){
                                hsf[s.charAt(begin)]--;
                            }
                        }
                       
                        begin++;
                        
               }

               int windowLen = end - begin + 1;
               if(windowLen < minWindowLen){
                    minWindowBegin = begin;
                    minWindowLen = windowLen;
               }
               
           }
           
           
       }
       
       t = s.substring(minWindowBegin, minWindowBegin+minWindowLen);
       System.out.println(s.replace(t,"["+t+"]"));

    }    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String [] tests = {"aaaaaabcdefghijklmnopqrstuvwxyz" +
        "abcdefghijklmnopqrstuvwxyz",
        "bcdefghijklmnopqrstuvwxyz",
        "aaaaaabcdefghijklmnopqrstuvwxyzhjlkera345hrejaf",
        "abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn",
        "abcdeasfghijklmn124345678!@#$%^&*opqrstsdfuvwxyz!*abcdefdsafghijklmn",
        "32q45hkjhaqkjhq345h'ljslkvcasd0af7asdfohj43h5;lashfdlasdhfa;sdfh92hq4prabcdefghijklfgdhmnopqrsasdftuvwxfadsyz",
        "abcdefghijklmnopqrstuvwxyzj53k4l;earjf;dsk;lkj354q;laejfsd;lkj;254rwe;fd\\shl;"};
        
        for(int i=0;i<tests.length;i++){
            System.out.print("smallestSubstringContainingTheAlphabet(\""+tests[i]+"\") -> ");
            smallestSubstringContainingTheAlphabet(tests[i]);
        }

    }
    
}
