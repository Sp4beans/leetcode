package com.sp4beans.leetcode.medium.solved;

//        给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
//
//        示例 1:
//
//        输入: 2
//        输出: 1
//        解释: 2 = 1 + 1, 1 × 1 = 1。
//        示例 2:
//
//        输入: 10
//        输出: 36
//        解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
//        说明: 你可以假设 n 不小于 2 且不大于 58。

public class P343 {
    private class Solution {
        public int integerBreak(int n) {
            int[] memory = new int[n + 1];
            memory[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j <= i - 1; j++) {
                    memory[i] = Math.max(memory[i], Math.max(j * memory[i - j], j * (i - j)));
                }
            }
            return memory[n];
        }
    }
}
