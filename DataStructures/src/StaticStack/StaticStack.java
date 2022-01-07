package StaticStack;

import StaticStackExceptions.StaticStackExceptions;

public class StaticStack implements Stack{
    int[] stack;
    int size = 5;
    int filled = 0; 
    public StaticStack(int size){
        stack = new int[size];
        this.size = size;
    }
    public StaticStack(){
        stack = new int[size];
    }
    @Override
    public void push(int value) throws StaticStackExceptions {
        // TODO Auto-generated method stub
        if (isFull()){
            throw new StaticStackExceptions("stackoverflowerror");
        }
        else{
            this.stack[this.filled] = value;
            this.filled = this.filled + 1;
        }
    }

    @Override
    public int pop() {
        // TODO Auto-generated method stub
        if (isEmpty()){
            return -1;
        }
        else{
            this.filled = this.filled - 1;
            int ret = this.stack[this.filled];
            this.stack[this.filled] = -1;
            return ret;
        }
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        if (this.filled == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isFull() {
        // TODO Auto-generated method stub
        if (this.filled == this.size){
            return true;
        }
        else{
            return false;
        }
    }
    
}
