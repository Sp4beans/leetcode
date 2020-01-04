package com.sp4beans.leetcode.easy;

//        给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
//
//        示例 1:
//
//        输入: [1,12,-5,-6,50,3], k = 4
//        输出: 12.75
//        解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
//         
//
//        注意:
//
//        1 <= k <= n <= 30,000。
//        所给数据范围 [-10,000，10,000]。

public class P643 {
    private static class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int length = nums.length;
            long sum = 0;
            long max = Integer.MIN_VALUE;
            for (int i = 0; i < length; i++) {
                if (i < k) {
                    sum += nums[i];
                    if (i == k - 1) {
                        max = sum;
                    }
                } else {
                    sum = sum + nums[i] - nums[i - k];
                    max = Long.max(sum, max);
                }
            }
            return (double) max / (double) k;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
