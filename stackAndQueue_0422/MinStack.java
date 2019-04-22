package exercise.stackAndQueue_0422;

/*
 实现一个最小栈。
 */
import java.util.Stack;

class MinStack {
    Stack<Integer> stack ;
    Stack<Integer>  minStack ;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.empty()){
            minStack.push(x);
        }else if(minStack.peek() >= x){
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        int data = stack.pop();
        if(data == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        if(stack.empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        return stack.peek();
    }

    public int getMin() {
        if(stack.empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */