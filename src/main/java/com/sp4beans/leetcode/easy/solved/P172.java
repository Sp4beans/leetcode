package com.sp4beans.leetcode.easy.solved;

//        给定一个整数 n，返回 n! 结果尾数中零的数量。
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


public class P172 {

    private static class Solution {
        public int trailingZeroes(int n) {
            int count = 0;
            while (n >= 5) {
                n = n / 5;
                count = count + n;
            }
            return count;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(3));
        System.out.println(solution.trailingZeroes(5));
        System.out.println(solution.trailingZeroes(52));
        System.out.println(solution.trailingZeroes(1808548329));
    }
}
