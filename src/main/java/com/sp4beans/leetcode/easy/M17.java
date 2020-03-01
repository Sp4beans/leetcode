package com.sp4beans.leetcode.easy;

//        输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//
//        示例 1:
//
//        输入: n = 1
//        输出: [1,2,3,4,5,6,7,8,9]
//         
//
//        说明：
//
//        用返回一个整数列表来代替打印
//        n 为正整数


public class M17 {

    private class Solution {
        public int[] printNumbers(int n) {
            int max = 10;
            for (int i = 1; i < n; i++) {
                max *= 10;
            }
            int[] result = new int[max - 1];
            for (int i = 1; i < max; i++) {
                result[i - 1] = i;
            }
            return result;
        }
    }
}
