package com.sp4beans.leetcode.easy.solved;

//        给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
//
//        说明：不要使用任何内置的库函数，如  sqrt。
//
//        示例 1：
//
//        输入：16
//        输出：True
//        示例 2：
//
//        输入：14
//        输出：False

public class P367 {
    private static class Solution {
        public boolean isPerfectSquare(int num) {
            if (num == 0) {
                return true;
            }
            int min = 1;
            int max = num;
            while (max >= min) {
                int mid = (min + max) >> 1;
                if (num % mid == 0 && num / mid == mid) {
                    return true;
                } else if (num / mid < mid) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            return false;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare(16));
        System.out.println(solution.isPerfectSquare(14));
        System.out.println(solution.isPerfectSquare(2147483647));
    }

}
