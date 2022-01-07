package StackArrayInf;

import java.util.ArrayList;

public class ArrayStack<T> implements Stack<T> {
    ArrayList<T> stack = new ArrayList<T>();
    int filled = 0;
    public ArrayStack(T value){
        this.stack.add(value);
        this.filled = this.filled + 1;
    }
    @Override
    public void push(T value) {
        // TODO Auto-generated method stub
        this.stack.add(value);
        this.filled = this.filled + 1;
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        if (isEmpty()){
            return null;
        }
        else{
            T value = stack.get(this.filled-1);
            stack.set(this.filled-1, null);
            this.filled = this.filled - 1;
            return value;
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
        return false;
    }
    
}
