package exercise.stackAndQueue_0422;

/*
 用队列实现栈
 */
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int usedSize = 0;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(!queue2.isEmpty()){
            queue2.add(x);
        }else{
            queue1.add(x);//默认加入queue1里面
        }
        this.usedSize++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        this.usedSize--;
        if(queue2.isEmpty()){
            for(int i=0; i<this.usedSize; i++){
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }else{
            for(int i=0; i<this.usedSize; i++){
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if(empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        if(queue2.isEmpty()){
            for(int i=0; i<this.usedSize-1; i++){
                queue2.add(queue1.poll());
            }
            int tmp = queue1.poll();
            queue2.add(tmp);
            return tmp;
        }else{
            for(int i=0; i<this.usedSize-1; i++){
                queue1.add(queue2.poll());
            }
            int tmp = queue2.poll();
            queue1.add(tmp);
            return tmp;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.usedSize == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */