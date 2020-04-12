package com.sp4beans.leetcode.easy.solved;

//        定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
//
//         
//
//        示例:
//
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.min();   --> 返回 -3.
//        minStack.pop();
//        minStack.top();      --> 返回 0.
//        minStack.min();   --> 返回 -2.
//         
//
//        提示：
//
//        各函数的调用总次数不超过 20000 次
//         
//
//        注意：本题与主站 155 题相同

import java.util.Stack;

public class M30 {

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

        public int min() {
            return min.peek();
        }
    }
}