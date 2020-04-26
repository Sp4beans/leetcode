package com.sp4beans.leetcode.medium.solved;

//        硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
//
//        示例1:
//
//        输入: n = 5
//        输出：2
//        解释: 有两种方式可以凑成总金额:
//        5=5
//        5=1+1+1+1+1
//        示例2:
//
//        输入: n = 10
//        输出：4
//        解释: 有四种方式可以凑成总金额:
//        10=10
//        10=5+5
//        10=5+1+1+1+1+1
//        10=1+1+1+1+1+1+1+1+1+1
//        说明：
//
//        注意:
//
//        你可以假设：
//
//        0 <= n (总金额) <= 1000000

public class M08_11 {

    private static class Solution {
        int mod = 1000000007;
        int[] coins = new int[]{25, 10, 5, 1};

        public int waysToChange(int n) {
            int[] ways = new int[n + 1];
            ways[0] = 1;
            for (int coin : coins) {
                for (int i = coin; i <= n; i++) {
                    ways[i] = (ways[i] + ways[i-coin]) % mod;
                }
            }
            return ways[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 10; i++) {
            System.out.println(solution.waysToChange(i));
        }
    }
}


