package Tries;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
    HashMap<Character,TrieNode> trie = new HashMap<Character,TrieNode>();
    public Trie(){
    }
    public void delete(String str){
        boolean bol = true;
        Character c;
        TrieNode node;
        HashMap<Character,TrieNode> cur = this.trie;
        ArrayList<HashMap<Character,TrieNode>> list = new ArrayList<HashMap<Character,TrieNode>>();
        list.add(cur);
        for (int i = 0; i < str.length(); i++){
            c = str.charAt(i);
            if (cur.containsKey(c)){
                node = cur.get(c);
                cur = node.getMap();
            }
            else{
                bol = false;
                break;
            }
            list.add(cur);
        }
        if (bol){
            HashMap<Character,TrieNode> head,head1;
            int size = list.size()-1;
            int actualsize = size;
            int count = str.length()-1;
            System.out.println(size);
            while (true){
                if (size < 0){
                    break;
                }
                else{
                    head = list.remove(size);
                    if (size == actualsize){
                        if (head.containsKey('$')){
                            head.remove('$');
                        }
                        else{
                            System.out.println("no complete string found");
                            break;
                        }
                    }
                    else{
                        c = str.charAt(count);
                        node = head.get(c);
                        head1 = node.getMap();
                        System.out.println(head + " " + head1);
                        if (head1.isEmpty()){
                            head.remove(c);  
                        }
                        else{
                            break;
                        }
                        count = count - 1;
                    }
                    size = size-1;
                }
            }
        }
        else{
            System.out.println("no such element");
        }
    }
    public boolean search(String str){
        boolean bol = true;
        Character c;
        TrieNode node;
        HashMap<Character,TrieNode> cur = this.trie;
        for (int i = 0; i < str.length(); i++){
            c = str.charAt(i);
            if (cur.containsKey(c)){
                node = cur.get(c);
                cur = node.getMap();
            }
            else{
                bol = false;
                break;
            }
        }
        if (bol){
            if (cur.containsKey('$')){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return bol;
        }
    }
    public void add(String str){
        Character c;
        TrieNode node;
        HashMap<Character,TrieNode> cur = this.trie;
        for (int i = 0; i < str.length(); i++){
            c = str.charAt(i);
            if (cur.containsKey(c)){
                node = cur.get(c);
                cur = node.getMap();
            }
            else{
                cur.put(c,new TrieNode());
                node = cur.get(c);
                cur = node.getMap();
            }
        }
        cur.put('$',new TrieNode());
    }
}
