package Tries;

public class Test {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("varun");
        t.add("tony");
        t.add("mark");
        t.add("marky");
        System.out.println(t.trie);
        System.out.println(t.search("mark"));
        t.delete("marky");
        System.out.println(t.search("mark"));
        System.out.println(t.search("marky"));
        System.out.println(t.trie);
    }
}
