package EhnancedQueCollection;

public class tester {
    public static void main(String[] args) {
        SLQue<String> slq = new SLQue<String>();
        slq.add("a");
        slq.add("b");
        String s;
        while (true){
            s = slq.pop();
            if (s == null){
                break;
            }
            else{
                System.out.println(s);
            }
        }
    }
}
