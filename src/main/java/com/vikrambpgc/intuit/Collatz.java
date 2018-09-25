package com.vikrambpgc.intuit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Collatz {

    private HashMap<Long, Long> map;

    public Collatz() {
        map = new HashMap<Long, Long>();
        //As chain length for 1 is always 1.
        map.put(1l, 1l);
    }
    
    public static void main(String[] args) {
        Collatz collatz = new Collatz();
        
        long maxChainForNumber = 1, maxChainLength = 1;
        for (long i = 1; i < 1000000; i++) {
            
            long chainLength = collatz.generateSequence(i);
            
            if (chainLength > maxChainLength) {
                maxChainLength = chainLength;
                maxChainForNumber = i;
            }
            //System.out.println(i + ":" + chainLength);
        }
        
        System.out.println("Max chain Length is: " + maxChainLength + " for Number: " + maxChainForNumber);
        
//        System.out.println(collatz.generateSequence(13));
//        System.out.println(collatz.generateSequence(5));
//        System.out.println(collatz.generateSequence(6171));
//        System.out.println(collatz.generateSequence(113383));
    }
    
    public long generateSequence(long n) {
        long tmp = n, count = 0;
        
        Set<Long> treeSet = new TreeSet<Long>();
        while (true) {    
            //System.out.println(tmp);
            //If map already contains the chain Length for a particular number
            //use that instead of redundant recalculation.
            if (map.containsKey(tmp)){
                count  = count + map.get(tmp);
                
                if (tmp != n) {
                    map.put(n, count);
                    
                    Iterator<Long> it = treeSet.iterator();
                    while(it.hasNext() == true) {
                        long unComputed = it.next();
                        map.put(unComputed, generateSequence(unComputed));
                    }
                    //Remove all elements.
                    treeSet.clear();
                }
                
                return count;
            } else {
                treeSet.add(tmp);
            }
            
            count++;
            
            if (tmp % 2 == 0) {
                tmp = tmp / 2;
            } else {
                tmp = 3 * tmp + 1;
            }
            
        }    
    }
}

//13 40 20 10 5 16 8 4 2 1