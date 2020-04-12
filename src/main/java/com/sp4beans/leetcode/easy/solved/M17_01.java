package com.sp4beans.leetcode.easy.solved;

//        设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
//
//        示例:
//
//        输入: a = 1, b = 1
//        输出: 2
//         
//
//        提示：
//
//        a, b 均可能是负数或 0
//        结果不会溢出 32 位整数

public class M17_01 {
     private class Solution {
        public int add(int a, int b) {
            while (b != 0) {
                int ans = (a ^ b);
                int eor = (a & b) << 1;
                a = ans;
                b = eor;
            }
            return a;
        }
    }
}
