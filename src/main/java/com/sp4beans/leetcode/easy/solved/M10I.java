package com.sp4beans.leetcode.easy.solved;

//        写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
//
//        F(0) = 0,   F(1) = 1
//        F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//        斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
//
//        答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//         
//
//        示例 1：
//
//        输入：n = 2
//        输出：1
//        示例 2：
//
//        输入：n = 5
//        输出：5
//         
//
//        提示：
//
//        0 <= n <= 100

public class M10I {

    private static class Solution {
        private static int MOD = 1000000007;

        public int fib(int n) {
            if (n == 0 || n == 1) {
                return n;
            }
            int[] ans = new int[n + 1];
            ans[0] = 0;
            ans[1] = 1;
            for (int i = 2; i <= n; i++) {
                ans[i] = (ans[i-1] + ans[i-2]) % MOD;
            }
            return ans[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(43));
    }
}
