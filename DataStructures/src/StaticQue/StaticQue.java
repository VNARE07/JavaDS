package StaticQue;

public class StaticQue {
    int[] que;
    int size = 5;
    int head = 0;
    int tail = 0;
    int filled = 0;
    public StaticQue(int size) {
        this.que = new int[size];
        this.size = size;
    }
    public void enque(int value){
        if (this.isFull()){
            System.out.println("que full");
        }
        else{
            this.filled = this.filled + 1;
            tail = this.tail % this.size;
            this.que[tail] = value;
            this.tail = this.tail + 1;
        }
    }
    public int deque(){
        if (this.isEmpty()){
            return -1;
        }
        else{
            this.filled = this.filled - 1;
            int start = this.head/this.size;
            int value = this.que[start];
            this.head = this.head + 1;
            return value;
        }
    }
    private boolean isFull() {
        if (this.filled == this.size){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isEmpty(){
        if (this.filled == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
