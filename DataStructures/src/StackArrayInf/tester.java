package StackArrayInf;

public class tester {
    public static void main(String[] args) {
        ArrayStack<String> as = new ArrayStack<String>("a");
        as.push("b");
        String str;
        while(true){
            if (as.isEmpty()){
                break;
            }
            else{
                str = as.pop();
                System.out.println(str);
            }
        }
    }
}
