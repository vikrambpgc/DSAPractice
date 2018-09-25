package com.vikrambpgc.strings;
import java.util.*;

public class Tries {
    private static class TrieNode {
        boolean isEnd;
        char label;
        Map<Character,TrieNode> next;
        
        public TrieNode(char label) {
            isEnd = false;
            this.label = label;
            next = new HashMap<Character,TrieNode>();
        }
    }
    
    public Tries() {
        head = new TrieNode(' ');
    }
    
    public TrieNode head;
    
    public static void main(String[] args) {
        Tries myTrie = new Tries();
        
        myTrie.insertString("by");
        myTrie.insertString("bye");
        myTrie.insertString("byed");
        myTrie.insertString("byay");
        
        System.out.println("by:"+myTrie.isPresentString("by"));
        System.out.println("bye:"+myTrie.isPresentString("bye"));
        System.out.println("byed:"+myTrie.isPresentString("byed"));
        System.out.println("byay:"+myTrie.isPresentString("byay"));
        System.out.println("byae:"+myTrie.isPresentString("byae"));
    }
    
    public void insertString(String s) {
        TrieNode head = this.head, current, prev = head;
        int i, strLen = s.length();

        for(i = 0;i < strLen;i++) {
            current = prev.next.get(s.charAt(i));
            if (current == null) {
                current = new TrieNode(s.charAt(i));
                prev.next.put(s.charAt(i), current);
            }
            prev = current;
        }
        prev.isEnd = true;
    }
    
    public boolean isPresentString(String s) {
        TrieNode head = this.head, current, prev = head;
        int i, strLen = s.length();

        for(i = 0;i < strLen;i++) {
            current = prev.next.get(s.charAt(i));
            if (current == null) {
                return false;
            }
            prev = current;
        }
        
        if (prev.isEnd == true) return true;
        
        return false;
    }
}
