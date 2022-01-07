package CircularQue;

public class CircularQueImp implements CircularQue {
    int[] que;
    int size = 5;
    int filled = 0;
    int start = 0;
    public CircularQueImp(int size){
        this.que = new int[size];
        this.size = size;
    }
    @Override
    public void add(int value) {
        // TODO Auto-generated method stub
        int pos = this.start + this.filled;
        pos = pos%this.size;
        System.out.println(pos + " currnet position to add values " + this.filled + " how many values");
        this.que[pos] = value;
        this.filled = this.filled + 1;
    }

    @Override
    public int pop() {
        // TODO Auto-generated method stub
        if (isEmpty()){
            return -1;
        }
        else{
            int ret = this.que[this.start];
            this.que[this.start] = -1;
            this.start = this.start + 1;
            this.start = this.start % this.size;
            this.filled = this.filled - 1;
            return ret;
        }
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        if (this.filled == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        // TODO Auto-generated method stub
        return false;
    }
}
