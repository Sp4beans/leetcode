package com.sp4beans.leetcode.medium;

//        给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
//
//        示例 1:
//
//        输入: nums = [1, 5, 1, 1, 6, 4]
//        输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
//        示例 2:
//
//        输入: nums = [1, 3, 2, 2, 3, 1]
//        输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
//        说明:
//        你可以假设所有输入都会得到有效的结果。
//
//        进阶:
//        你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？

import java.util.Arrays;

public class P342 {
    private void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[nums.length];
        int idx = 0;
        int mid = nums.length % 2 == 0 ? nums.length / 2 - 1 : nums.length / 2;
        int n = 0;
        while (idx < nums.length) {
            ans[idx++] = nums[mid - n];
            if (idx < nums.length) {
                ans[idx++] = nums[nums.length - n - 1];
            }
            n++;
        }
        for (int i = 0; i < ans.length; i++) {
            nums[i] = ans[i];
        }
    }
}
