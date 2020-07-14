package com.sp4beans.leetcode.medium;

//        给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
//
//         
//
//        示例 1:
//
//        输入: coins = [1, 2, 5], amount = 11
//        输出: 3
//        解释: 11 = 5 + 5 + 1
//        示例 2:
//
//        输入: coins = [2], amount = 3
//        输出: -1
//         
//
//        说明:
//        你可以认为每种硬币的数量是无限的。

public class P322 {

    private class Solution {
        int[] count;

        public int coinChange(int[] coins, int amount) {
            if (amount < 1) {
                return 0;
            }
            count = new int[amount];
            return doChangeCoin(coins, amount);
        }

        private int doChangeCoin(int[] coins, int rem) {
            if (rem < 0) {
                return -1;
            }
            if (rem == 0) {
                return 0;
            }
            if (count[rem - 1] != 0) {
                return count[rem - 1];
            }
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = doChangeCoin(coins, rem - coin);
                if (res >= 0 && res < min) {
                    min = res + 1;
                }
            }
            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
            return count[rem - 1];
        }
    }
}
