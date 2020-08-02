package com.sp4beans.leetcode.medium.solved;

//        给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
//
//        返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
//
//         
//
//        示例：
//
//        输入：nums: [1, 1, 1, 1, 1], S: 3
//        输出：5
//        解释：
//
//        -1+1+1+1+1 = 3
//        +1-1+1+1+1 = 3
//        +1+1-1+1+1 = 3
//        +1+1+1-1+1 = 3
//        +1+1+1+1-1 = 3
//
//        一共有5种方法让最终目标和为3。
//         
//
//        提示：
//
//        数组非空，且长度不会超过 20 。
//        初始的数组的和不会超过 1000 。
//        保证返回的最终结果能被 32 位整数存下。

//public class Solution {
//    public int findTargetSumWays(int[] nums, int S) {
//        int[][] dp = new int[nums.length][2001];
//        dp[0][nums[0] + 1000] = 1;
//        dp[0][-nums[0] + 1000] += 1;
//        for (int i = 1; i < nums.length; i++) {
//            for (int sum = -1000; sum <= 1000; sum++) {
//                if (dp[i - 1][sum + 1000] > 0) {
//                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
//                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
//                }
//            }
//        }
//        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
//    }
//}
//
public class P494 {
    private static class Solution {
        int count = 0;

        public int findTargetSumWays(int[] nums, int S) {
            calculate(nums, 0, 0, S);
            return count;
        }

        public void calculate(int[] nums, int i, int sum, int S) {
            if (i == nums.length) {
                if (sum == S) {
                    count++;
                }
                return;
            }

            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(
                new int[] {41, 1, 7, 20, 44, 13, 4, 8, 21, 4, 45, 37, 18, 47, 8, 17, 10, 4, 27, 26}, 38));
    }

}