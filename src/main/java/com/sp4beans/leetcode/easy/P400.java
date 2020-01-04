package com.sp4beans.leetcode.easy;

//        在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
//
//        注意:
//        n 是正数且在32为整形范围内 ( n < 231)。
//
//        示例 1:
//
//        输入:
//        3
//
//        输出:
//        3
//        示例 2:
//
//        输入:
//        11
//
//        输出:
//        0
//
//        说明:
//        第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。

public class P400 {
    private static class Solution {
        public int findNthDigit(int n) {
            int digit = 1;
            Long t = 9L;

            while (n - t * digit > 0) {
                n = (int) (n - t * digit);
                t = t * 10;
                digit++;
            }

            int basevalue = (int) Math.pow(10, digit - 1);
            int no_basevalue = (n - 1) / digit;
            basevalue += no_basevalue;
            char c = String.valueOf(basevalue).toCharArray()[(n - 1) % digit];
            return Integer.parseInt("" + c);
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(3));
        System.out.println(solution.findNthDigit(11));
    }
}
