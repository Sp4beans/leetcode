package com.sp4beans.leetcode.medium.solved;

//        输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//
//        例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
//
//         
//
//        示例 1：
//
//        输入：n = 12
//        输出：5
//        示例 2：
//
//        输入：n = 13
//        输出：6
//         
//
//        限制：
//
//        1 <= n < 2^31
//        注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/

public class M43 {
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
}
