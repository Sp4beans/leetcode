package com.sp4beans.leetcode.easy.solved;

//        设计一个算法，算出 n 阶乘有多少个尾随零。
//
//        示例 1:
//
//        输入: 3
//        输出: 0
//        解释: 3! = 6, 尾数中没有零。
//        示例 2:
//
//        输入: 5
//        输出: 1
//        解释: 5! = 120, 尾数中有 1 个零.
//        说明: 你算法的时间复杂度应为 O(log n) 。

public class M16_05 {
    private class Solution {
        public int trailingZeroes(int n) {
            int result = 0;
            while (n > 0) {
                n /= 5;
                result+=n;
            }
            return result;
        }
    }
}
