package Tries;

import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> map = new HashMap<Character, TrieNode>();
    public TrieNode(){
    }
    public void add(Character c){
        this.map.put(c,new TrieNode());
    }
    public HashMap<Character, TrieNode> getMap(){
        return this.map;
    }
}
