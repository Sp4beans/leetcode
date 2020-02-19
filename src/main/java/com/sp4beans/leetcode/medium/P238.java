package com.sp4beans.leetcode.medium;

//        给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
//
//        示例:
//
//        输入: [1,2,3,4]
//        输出: [24,12,8,6]
//        说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
//
//        进阶：
//        你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）

public class P238 {
    private class Solution {
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int[] left = new int[length];
            int[] right = new int[length];

            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    left[i] = nums[i];
                } else {
                    left[i] = nums[i] * left[i-1];
                }

                if (i == 0) {
                    right[length - i - 1] = nums[length - i - 1];
                } else {
                    right[length - i - 1] = nums[length - i - 1] * right[length - i];
                }
            }

            int[] ans = new int[length];
            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    ans[i] = right[i + 1];
                } else if (i == length - 1) {
                    ans[i] = left[i - 1];
                } else {
                    ans[i] = left[i - 1] * right[i + 1];
                }
            }

            return ans;
        }
    }
}
