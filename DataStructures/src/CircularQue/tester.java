package CircularQue;

public class tester {
    public static void main(String[] args) {
        CircularQueImp cqi = new CircularQueImp(3);
        cqi.add(1);
        cqi.add(2);
        cqi.add(3);
        System.out.println(cqi.pop());
        System.out.println(cqi.pop());
        cqi.add(4);
        cqi.add(5);
        System.out.println(cqi.pop());
        System.out.println(cqi.pop());
        System.out.println(cqi.pop());
        System.out.println(cqi.pop());
        cqi.add(6);
        System.out.println(cqi.pop());
    }
}
