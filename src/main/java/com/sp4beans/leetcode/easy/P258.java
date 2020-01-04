package com.sp4beans.leetcode.easy;

//        给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
//
//        示例:
//
//        输入: 38
//        输出: 2
//        解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
//        进阶:
//        你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？

//         10 -> 1
//         11 -> 2
//         12 -> 3
//         13 -> 4
//
//         18 -> 9
//         19 -> 1
//         20 -> 2
//

public class P258 {
    private static class Solution {
        public int addDigits(int num) {
            if (num == 0) {
                return 0;
            }
            return num % 9 == 0 ? 9 : num % 9;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.addDigits(38));
    }
}
