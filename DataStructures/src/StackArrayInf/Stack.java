package StackArrayInf;

public interface Stack<T> {
    public void push(T value);
    public T pop();
    public boolean isEmpty();
    public boolean isFull();
}
