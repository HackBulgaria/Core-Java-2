package pkg1.primes.in.an.interval;
import java.util.*;

/**
 *
 * @author Miglen Evlogiev
 * 
 */

   
public class PrimesInAnInterval {
   
public static void primesInAnInterval(int from, int to){
 
    if(to>from && from >= 1){
         int num = 2;
         
         Map<Integer, Integer> primes = new HashMap<Integer, Integer>();

         // Each element id eq the value
         for(int i=num;i<=to;i++)
             primes.put(i,i);

        while(num*num < to){
            for(int i=num;i<=to;i+=num){
                if(i==num){
                    continue;
                }
            primes.remove(i);             
            }
            
           // get the next element bigger than num
           //System.out.println(primes.toString()); 
           for (int key: primes.keySet())
               if(key>num){num=key;break;}
          }  

        
    StringBuilder sb = new StringBuilder();
    for (int key: primes.keySet()){
        if(key<from) continue;
        if (sb.length() > 0) sb.append(", ");
        else sb.append("[");
        sb.append(key);
    }
    sb.append("]");
        
   System.out.println(sb.toString());
        
    }else System.out.println("invalid input");
    
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Map<Integer, Integer> tests = new HashMap<Integer, Integer>();
        tests.put(2,20);
        tests.put(10,30);
        tests.put(20,10);
        tests.put(-20,10);
        tests.put(3,100);
        tests.put(4,1000);
        tests.put(5,10000);
        tests.put(6,100000);
        tests.put(7,1000000);

        for (int key: tests.keySet()){
            System.out.print("primesInAnInterval("+ key +","+ tests.get(key) +") -> ");
               primesInAnInterval(key,tests.get(key));
        }
 
    }
    
}
