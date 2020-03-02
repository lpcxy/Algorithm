package com.liping.Util;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(minStack.isEmpty() ? x : Math.min(x, minStack.peek()));
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty()){
            throw new IllegalArgumentException("stack is empty");
        }
        return stack.peek();
    }

    public int min() {
        if(minStack.isEmpty()){
            throw new IllegalArgumentException("stack is empty");
        }
        return minStack.peek();
    }
}
