package com.sp4beans.leetcode.hard;

//        给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
//
//        示例:
//
//        输入: 13
//        输出: 6
//        解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。

public class P233 {
    private static class Solution {
        public int countDigitOne(int n) {
            int ans = 0;
            int cur = 0;
            int tmp = n;
            int exp = 1;
            while(tmp > 0) {
                int num = tmp % 10;
                tmp = tmp / 10;
                if (num < 1) {
                    ans = ans + tmp * exp;
                } else if (num == 1) {
                    ans = ans + tmp * exp + cur + 1;
                } else {
                    ans = ans + (tmp + 1) * exp;
                }
                cur = num * exp + cur;
                exp *= 10;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countDigitOne(12));
        System.out.println(solution.countDigitOne(13));
    }
}
