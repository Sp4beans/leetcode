package com.sp4beans.leetcode.easy;

//        请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
//
//        让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
//
//        由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
//
//         
//
//        示例 1：
//
//        输入：n = 5
//        输出：12
//        解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
//        示例 2：
//
//        输入：n = 100
//        输出：682289015
//         
//
//        提示：
//
//        1 <= n <= 100

public class P1175 {

    private static class Solution {

        int mod = 1000000007;

        public int numPrimeArrangements(int n) {

            int primeCount = getPrimeCount(n);
            int noPrimeCount = n - primeCount;
            return (int) ((func(primeCount) * func(noPrimeCount)) % mod);
        }

        public long func(int n) {
            long ans = 1;
            for (int i = 1; i <= n; i++) {
                ans = (ans * i) % mod;
            }
            return ans;
        }

        public int getPrimeCount(int n) {
            if (n == 1) return 0;
            if (n == 2) return 1;
            if (n <= 4) return 2;
            if (n <= 6) return 3;
            if (n <= 10) return 4;
            if (n <= 12) return 5;
            if (n <= 16) return 6;
            if (n <= 18) return 7;
            if (n <= 22) return 8;
            if (n <= 28) return 9;
            if (n <= 30) return 10;
            if (n <= 36) return 11;
            if (n <= 40) return 12;
            if (n <= 42) return 13;
            if (n <= 46) return 14;
            if (n <= 52) return 15;
            if (n <= 58) return 16;
            if (n <= 60) return 17;
            if (n <= 66) return 18;
            if (n <= 70) return 19;
            if (n <= 72) return 20;
            if (n <= 78) return 21;
            if (n <= 82) return 22;
            if (n <= 88) return 23;
            if (n <= 96) return 24;
            if (n <= 100) return 25;
            return 25;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.numPrimeArrangements(4));
        System.out.println(solution.numPrimeArrangements(5));
        System.out.println(solution.numPrimeArrangements(100));
    }
}
