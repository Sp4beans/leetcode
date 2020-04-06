package com.sp4beans.leetcode.easy;

//        编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
//
//        示例：
//
//        输入： a = 1, b = 2
//        输出： 2

public class M16_07 {
    private class Solution {
        public int maximum(int a, int b) {
            long c=a;long d=b;
            int res=(int)((c-d)>>>63);// >>>和>>区别 >>>无符号右移
            return b*res+a*(res^1);
        }
    }
}
