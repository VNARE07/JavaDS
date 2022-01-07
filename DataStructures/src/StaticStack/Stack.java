package StaticStack;

import StaticStackExceptions.StaticStackExceptions;

public interface Stack{
    public void push(int size) throws StaticStackExceptions;
    public int pop();
    public boolean isEmpty();
    public boolean isFull();
}
