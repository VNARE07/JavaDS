package Tries;

public class Test {
    public static void main(String[] args) {
        TrieUpdate t = new TrieUpdate();
        // t.add("varun");
        // t.add("tony");
        // t.add("mark");
        // t.add("markyy");
        // t.add("ma");
        // t.add("va");
        System.out.println(t.trie);
        System.out.println(t.search("mark"));
        System.out.println(t.search("mark"));
        System.out.println(t.search("marky"));
        System.out.println(t.trie);
        t.searilize();
        // System.out.println("deserlization started");
        // TrieNode node = t.deserialize("ma$)rkyy$)))$)))))va$)run$))))))tony$)))))");
        // t.trie = node;
        // System.out.println("updtaed");
        // System.out.println(t.search("mark"));
        // System.out.println(t.search("mark"));
        // System.out.println(t.search("markyy"));
    }
}
