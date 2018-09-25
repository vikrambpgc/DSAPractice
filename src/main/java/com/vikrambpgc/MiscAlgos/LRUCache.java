package com.vikrambpgc.MiscAlgos;
import java.util.*;

public class LRUCache {
	
	LinkedHashMap<Integer,Integer> hash;
	int capacity;
    
    public LRUCache(int capacity) {
    	this.capacity = capacity;
        hash = new LinkedHashMap<Integer,Integer>(capacity);
    }
    
    public int get(int key) {
    	int retValue = -1;
    	if (hash.containsKey(key)) {
    		retValue = hash.get(key);
    		hash.remove(key);
    		hash.put(key, retValue);
    	}
        
    	return retValue;
    }
    
    public void set(int key, int value) {
        if (hash.containsKey(key)) {
        	hash.remove(key);
        } else if (hash.size() == capacity && capacity != 0){
        	hash.remove(hash.keySet().iterator().next());
        }
        
        hash.put(key, value);
    }
}
