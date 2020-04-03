package com.sp4beans.leetcode.easy.solved;


//        用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//         
//
//        示例 1：
//
//        输入：
//        ["CQueue","appendTail","deleteHead","deleteHead"]
//        [[],[3],[],[]]
//        输出：[null,null,3,-1]
//        示例 2：
//
//        输入：
//        ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//        [[],[],[5],[2],[],[]]
//        输出：[null,-1,null,null,5,2]
//        提示：
//
//        1 <= values <= 10000
//        最多会对 appendTail、deleteHead 进行 10000 次调用

import java.util.Stack;

public class M09 {
    private class CQueue {

        private Stack<Integer> s1;
        private Stack<Integer> s2;

        public CQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void appendTail(int value) {
            s1.push(value);
        }

        public int deleteHead() {
            if (s2.isEmpty() && s1.isEmpty()) {
                return -1;
            }
            if (s2.isEmpty()) {
                while(!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }
    }
}
