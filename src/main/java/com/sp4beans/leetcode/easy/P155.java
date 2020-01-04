package com.sp4beans.leetcode.easy;

//        设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//
//        push(x) -- 将元素 x 推入栈中。
//        pop() -- 删除栈顶的元素。
//        top() -- 获取栈顶元素。
//        getMin() -- 检索栈中的最小元素。
//        示例:
//
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin();   --> 返回 -3.
//        minStack.pop();
//        minStack.top();      --> 返回 0.
//        minStack.getMin();   --> 返回 -2.

import java.util.Stack;

public class P155 {
    private class MinStack {

        Stack<Integer> data;
        Stack<Integer> min;
        int minVal;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new Stack<>();
            min = new Stack<>();
            minVal = Integer.MAX_VALUE;
        }

        public void push(int x) {
            data.push(x);
            minVal = Integer.min(x, minVal);
            min.push(minVal);
        }

        public void pop() {
            data.pop();
            min.pop();
            if (min.size() > 0) {
                minVal = min.peek();
            } else {
                minVal = Integer.MAX_VALUE;
            }
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
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
}
