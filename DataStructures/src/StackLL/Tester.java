package StackLL;

public class Tester {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.add(1);
        s.add(2);
        Node<Integer> cur;
        while (true){
            cur = s.pop();
            if (cur == null){
                break;
            }
            else{
                System.out.println(cur.data);
            }
        }
    }
}
