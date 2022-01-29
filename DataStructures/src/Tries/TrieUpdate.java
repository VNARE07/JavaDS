package Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TrieUpdate {
    TrieNode trie = new TrieNode();
    public TrieUpdate(){
        try (BufferedReader reader = new BufferedReader(new FileReader("./SavedData.txt"))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.getProperty("line.separator");
            try {
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // delete the last new line separator
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String content = stringBuilder.toString();
            System.out.println("readComplete: " + content);
            if (content.length() != 0){
                this.trie = this.deserialize(content);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void delete(String str){
        boolean bol = true;
        Character c;
        TrieNode node;
        HashMap<Character,TrieNode> cur = this.trie.getMap();
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
        HashMap<Character,TrieNode> cur = this.trie.getMap();
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
        HashMap<Character,TrieNode> cur = this.trie.getMap();
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
    public void searilize(){
        String save = "";
        HashMap<Character,TrieNode> d1 = this.trie.getMap();
        ArrayList<HashMap<Character,TrieNode>> upnode = new ArrayList<HashMap<Character,TrieNode>>();
        ArrayList<String> status = new ArrayList<String>();
        ArrayList<Character> stack = new ArrayList<Character>(this.trie.getMap().keySet());
        for (int i = 0; i < stack.size(); i++){
            status.add("ud");
            upnode.add(d1);
        }
        // System.out.println(stack);
        // System.out.println(upnode);
        Character head,child;
        String s;
        HashMap<Character,TrieNode> map1,map2;
        // System.out.println("serlization started");
        while (true){
            if (stack.size()-1 < 0){
                break;
            }
            else{
                head = stack.remove(stack.size()-1);
                map1 = upnode.remove(upnode.size()-1);
                s = status.remove(status.size()-1);
                if (s.equals("ud")){
                    stack.add(head);
                    upnode.add(map1);
                    status.add("d");
                    save = save + head;
                    map2 = map1.get(head).getMap();
                    ArrayList<Character> children = new ArrayList<Character>(map2.keySet());
                    // System.out.println(stack);
                    // System.out.println(upnode);
                    for (int i = 0; i < children.size();i++){
                        child = children.get(i);
                        stack.add(child);
                        upnode.add(map2);
                        status.add("ud");
                    }
                }
                else{
                    save = save + ")";
                }
            }
        }
        System.out.println(save);
        try {
            FileWriter myWriter = new FileWriter("./SavedData.txt");
            myWriter.write(save);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public TrieNode deserialize(String str){
        TrieNode node = new TrieNode();
        ArrayList<TrieNode> stack = new ArrayList<TrieNode>();
        ArrayList<Character> ch = new ArrayList<Character>();
        TrieNode par,node1,node2;
        Character c;
        HashMap<Character,TrieNode> map,map1;
        for (int i = 0; i < str.length(); i++){
            // System.out.println(stack.size());
            // System.out.println(ch);
            // System.out.println(stack);
            if (str.charAt(i) == ')'){
                System.out.println(stack.remove(stack.size()-1));
                System.out.println(ch.remove(ch.size()-1));
            }
            else{
                node1 = new TrieNode();
                if (stack.size() == 0){
                    par = node;
                    map = par.getMap();
                    map.put(str.charAt(i),node1);
                    stack.add(node);
                    ch.add(str.charAt(i));
                }
                else{
                    par = stack.remove(stack.size() - 1);
                    c = ch.remove(ch.size()-1);
                    map = par.getMap();
                    // System.out.println(map);
                    node2 = map.get(c);
                    map1 = node2.getMap();
                    map1.put(str.charAt(i),node1);
                    stack.add(par);
                    stack.add(node2);
                    ch.add(c);
                    ch.add(str.charAt(i));
                }
            }
        }
        // System.out.println(node.getMap());
        return node;
    }
}

