package com.sp4beans.leetcode.easy;

//        一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//
//        答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//        示例 1：
//
//        输入：n = 2
//        输出：2
//        示例 2：
//
//        输入：n = 7
//        输出：21
//        提示：
//
//        0 <= n <= 100

public class M10II {
    private static class Solution {
        private static int MOD = 1000000007;

        public int numWays(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            int[] ans = new int[n + 1];
            ans[0] = 1;
            ans[1] = 1;
            for (int i = 2; i <= n; i++) {
                ans[i] = (ans[i-1] + ans[i-2]) % MOD;
            }
            return ans[n];
        }
    }
}
