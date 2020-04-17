package com.sp4beans.leetcode.medium;

//        栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和
// isEmpty。当栈为空时，peek 返回 -1。
//
//        示例1:
//
//        输入：
//        ["SortedStack", "push", "push", "peek", "pop", "peek"]
//        [[], [1], [2], [], [], []]
//        输出：
//        [null,null,null,1,null,2]
//        示例2:
//
//        输入：
//        ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
//        [[], [], [], [1], [], []]
//        输出：
//        [null,null,null,null,null,true]
//        说明:
//
//        栈中的元素数目在[0, 5000]范围内。

import java.util.Stack;

public class M03_05 {
    private class SortedStack {

        Stack<Integer> stack;
        Stack<Integer> tmp;

        public SortedStack() {
            stack = new Stack<>();
            tmp = new Stack<>();
        }

        public void push(int val) {
            int max = stack.isEmpty() ? Integer.MIN_VALUE : stack.peek();
            int min = tmp.isEmpty() ? Integer.MAX_VALUE : tmp.peek();
            if (val > max) {
                while (val > max && !stack.isEmpty()) {
                    tmp.push(stack.pop());
                    max = stack.isEmpty() ? Integer.MIN_VALUE : stack.peek();
                }
            } else if (val < min) {
                while (val < min && !tmp.isEmpty()) {
                    stack.push(tmp.pop());
                    min = tmp.isEmpty() ? Integer.MAX_VALUE : tmp.peek();
                }
            }
            stack.push(val);
        }

        public void pop() {
            if (isEmpty()) {
                return;
            }
            while (!tmp.isEmpty()) {
                stack.push(tmp.pop());
            }
            stack.pop();
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            while (!tmp.isEmpty()) {
                stack.push(tmp.pop());
            }
            return stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty() && tmp.isEmpty();
        }
    }

    /**
     * Your SortedStack object will be instantiated and called as such:
     * SortedStack obj = new SortedStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.isEmpty();
     */
}
