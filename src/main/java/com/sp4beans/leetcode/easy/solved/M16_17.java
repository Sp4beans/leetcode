package com.sp4beans.leetcode.easy.solved;

//        给定一个整数数组（有正数有负数），找出总和最大的连续数列，并返回总和。
//
//        示例：
//
//        输入： [-2,1,-3,4,-1,2,1,-5,4]
//        输出： 6
//        解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
//        进阶：
//
//        如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

public class M16_17 {
    private class Solution {
        public int maxSubArray(int[] nums) {
            int ans = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    sum = nums[i];
                } else {
                    if (sum < 0) {
                        sum = nums[i];
                    } else {
                        sum += nums[i];
                    }
                }
                ans = Integer.max(ans, sum);
            }
            return ans;
        }
    }
}
