package com.sp4beans.leetcode.medium.solved;

//        给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//         
//
//        示例 1:
//
//        输入: [2,3,-2,4]
//        输出: 6
//        解释: 子数组 [2,3] 有最大乘积 6。
//        示例 2:
//
//        输入: [-2,0,-1]
//        输出: 0
//        解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

public class P152 {
    private class Solution {
        public int maxProduct(int[] nums) {
            int[][] max = new int[nums.length][2];
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    max[i][0] = nums[i];
                    max[i][1] = nums[i];
                    ans = nums[i];
                } else {
                    max[i][0] = Math.max(max[i-1][0] * nums[i], Math.max(max[i-1][1] * nums[i], nums[i]));
                    max[i][1] = Math.min(max[i-1][0] * nums[i], Math.min(max[i-1][1] * nums[i], nums[i]));
                    ans = Math.max(ans, max[i][0]);
                }
            }
            return ans;
        }
    }
}
