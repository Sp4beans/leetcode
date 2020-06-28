package com.sp4beans.leetcode.medium.solved;

//        给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1]
// 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//
//        示例 1：
//
//        输入: 2
//        输出: 1
//        解释: 2 = 1 + 1, 1 × 1 = 1
//        示例 2:
//
//        输入: 10
//        输出: 36
//        解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
//        提示：
//
//        2 <= n <= 58

public class M14_1 {
    private static class Solution {
        public int cuttingRope(int n) {
            int[][] dp = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i][1] = i;
            }
            for (int i = 2; i <= n; i++) {
                for (int d = 2; d <= i; d++) {
                    for (int j = 1; j < i; j++) {
                        for (int dj = 1; dj <= j && dj < d; dj++) {
                            dp[i][d] = Math.max(dp[i][d], dp[j][dj] * dp[i - j][d - dj]);
                        }
                    }
                }
            }
            int ans = 0;
            for (int i = 2; i <= n; i++) {
                ans = Math.max(ans, dp[n][i]);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(2));
        System.out.println(solution.cuttingRope(10));
    }
}
