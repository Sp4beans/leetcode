package com.sp4beans.leetcode.easy.solved;

//        给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//        你可以假设数组中无重复元素。
//
//        示例 1:
//
//        输入: [1,3,5,6], 5
//        输出: 2
//        示例 2:
//
//        输入: [1,3,5,6], 2
//        输出: 1
//        示例 3:
//
//        输入: [1,3,5,6], 7
//        输出: 4
//        示例 4:
//
//        输入: [1,3,5,6], 0
//        输出: 0

public class P35 {
    private static class Solution {
        public int searchInsert(int[] nums, int target) {
            int min = 0;
            int max = nums.length - 1;
            int mid = min;
            while (min <= max) {
                mid = (min + max) >> 1;
//                System.out.println(min + " - " + max + " - " + mid);
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            return nums[mid] > target ? mid : mid + 1;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
