package StaticStack;

public class tester {
    public static void main(String[] args) {
        StaticStack ss = new StaticStack(3);
        for (int i = 0; i < 5 ; i++){
            try {
                ss.push(i);
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
    }
}
