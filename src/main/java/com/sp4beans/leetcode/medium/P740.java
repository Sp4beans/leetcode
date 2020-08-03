package com.sp4beans.leetcode.medium;

//        给定一个整数数组 nums ，你可以对它进行一些操作。
//
//        每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
//
//        开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
//
//        示例 1:
//
//        输入: nums = [3, 4, 2]
//        输出: 6
//        解释:
//        删除 4 来获得 4 个点数，因此 3 也被删除。
//        之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
//        示例 2:
//
//        输入: nums = [2, 2, 3, 3, 3, 4]
//        输出: 9
//        解释:
//        删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。
//        之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//        总共获得 9 个点数。
//        注意:
//
//        nums的长度最大为20000。
//        每个整数nums[i]的大小都在[1, 10000]范围内。

public class P740 {
    private static class Solution {
        private int len = 10001;

        public int deleteAndEarn(int[] nums) {
            int[] count = new int[len];
            int max = 1;
            for (int num : nums) {
                count[num]++;
                max = Math.max(max, num + 1);
            }

            int[] dp = new int[max];
            for (int i = 1; i < max; i++) {
                if (count[i] == 0) {
                    dp[i] = dp[i - 1];
                } else if (count[i] > 0) {
                    if (i <= 2) {
                        dp[i] = Math.max(dp[i - 1], i * count[i]);
                    } else {
                        dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * count[i]);
                    }
                }
            }
            return dp[max - 1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.deleteAndEarn(
                new int[] {12, 32, 93, 17, 100, 72, 40, 71, 37, 92, 58, 34, 29, 78, 11, 84, 77, 90, 92, 35, 12, 5, 27,
                        92, 91, 23, 65, 91, 85, 14, 42, 28, 80, 85, 38, 71, 62, 82, 66, 3, 33, 33, 55, 60, 48, 78, 63,
                        11, 20, 51, 78, 42, 37, 21, 100, 13, 60, 57, 91, 53, 49, 15, 45, 19, 51, 2, 96, 22, 32, 2, 46,
                        62, 58, 11, 29, 6, 74, 38, 70, 97, 4, 22, 76, 19, 1, 90, 63, 55, 64, 44, 90, 51, 36, 16, 65, 95,
                        64, 59, 53, 93}));
    }
}
