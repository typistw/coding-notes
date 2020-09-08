package com.leetcode.easy;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ImplementStackUsingQueues {

    public static void main(String[] args) {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());   // returns 2
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.empty()); // returns false
    }

    private Queue queue;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        queue = new LinkedBlockingQueue();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        for(int i = 0 ; i < size - 1; i++){
           int val  =  (int)queue.poll();
           queue.add(val);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return (int)queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return  (int)queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return  queue.isEmpty();
    }

}
