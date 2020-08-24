package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 *
 * Constraints:
 *
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class MinStack {

    private List<Integer> stackList;
    private List<Integer> minList;

    public MinStack() {
        stackList  = new ArrayList<>();
        minList = new ArrayList<>();
    }

    public void push(int x) {
        stackList.add(x);
        if(x <= getMin()){
            minList.add(x);
        }
    }

    public void pop() {
        int val = stackList.get(stackList.size() - 1);
        stackList.remove(stackList.size() - 1);
        if(val == getMin()){
            minList.remove(minList.size() - 1);
        }
    }

    public int top() {
       return stackList.get(stackList.size() - 1);
    }

    public int getMin() {
      if(minList.isEmpty()){
          return Integer.MAX_VALUE;
      }

      return minList.get(minList.size() - 1);
    }
}
