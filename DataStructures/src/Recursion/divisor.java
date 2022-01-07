package Recursion;

public class divisor {
    public int solver(int n,int j){
        if (n < j){
            return 0;
        }
        else if (n == j){
            return 1;
        }
        else{
            return 1 + solver(n-j,j);
        }
    }
}
