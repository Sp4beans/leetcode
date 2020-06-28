package com.sp4beans.leetcode.medium;

//        给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
//        示例 1:
//
//        输入: n = 12
//        输出: 3
//        解释: 12 = 4 + 4 + 4.
//        示例 2:
//
//        输入: n = 13
//        输出: 2
//        解释: 13 = 4 + 9.

import java.util.HashSet;
import java.util.Set;

public class P279 {

    private static class Solution {
        Set<Integer> nums = new HashSet<>();

        public int numSquares(int n) {
            nums.clear();
            for (int i = 1; i * i <= n; i ++) {
                nums.add(i * i);
            }

            for (int i = 1; ; i++) {
                if (canDividedBy(n, i)) {
                    return i;
                }
            }
        }

        boolean canDividedBy(int n, int count) {
            if (count == 1) {
                return nums.contains(n);
            }

            for (Integer square : nums) {
                if (canDividedBy(n - square, count - 1)) {
                    return true;
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
        System.out.println(solution.numSquares(13));
        System.out.println(solution.numSquares(49));
        System.out.println(solution.numSquares(57));
        System.out.println(solution.numSquares(8328));
    }

}
