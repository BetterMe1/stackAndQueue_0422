package exercise.stackAndQueue_0422;

/*
设计循环队列
 */

class MyCircularQueue {
    private int[] ele;
    private int front = 0;
    private int rear = 0;
    private int usedSize = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.ele = new int[k+1];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        this.ele[this.rear] = value;
        this.rear = (this.rear+1)%this.ele.length ;
        this.usedSize++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        this.front = (this.front+1)%this.ele.length ;
        this.usedSize--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return this.ele[this.front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return this.rear == 0 ? this.ele[ele.length-1] : this.ele[this.rear-1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return ((this.rear+1)%(this.ele.length ))== this.front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
