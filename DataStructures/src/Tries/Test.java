package Tries;

public class Test {
    public static void main(String[] args) {
        TrieUpdate t = new TrieUpdate();
        System.out.println(t.search("mark"));
        System.out.println(t.search("mark"));
        System.out.println(t.search("marky"));
        System.out.println(t.search("roxann"));
        System.out.println(t.search("holland"));
        System.out.println(t.search("holland"));
        System.out.println(t.search("mark"));
        System.out.println(t.search("markyy"));
        t.searilize();
    }
}
