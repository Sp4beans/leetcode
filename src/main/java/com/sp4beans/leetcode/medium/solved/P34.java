package com.sp4beans.leetcode.medium.solved;

//        给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//        你的算法时间复杂度必须是 O(log n) 级别。
//
//        如果数组中不存在目标值，返回 [-1, -1]。
//
//        示例 1:
//
//        输入: nums = [5,7,7,8,8,10], target = 8
//        输出: [3,4]
//        示例 2:
//
//        输入: nums = [5,7,7,8,8,10], target = 6
//        输出: [-1,-1]

public class P34 {
    private class Solution {
        public int[] searchRange(int[] nums, int target) {
            int firstIndex = firstIndex(nums, target);
            if (firstIndex == -1) {
                return new int[]{-1, -1};
            }
            int lastIndex = lastIndex(nums, target);
            return new int[]{firstIndex, lastIndex};
        }

        private int firstIndex(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int ans = -1;
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (nums[mid] == target) {
                    if (mid == 0 || nums[mid - 1] != target) {
                        ans = mid;
                        break;
                    } else {
                        high = mid - 1;
                    }
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return ans;
        }

        private int lastIndex(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int ans = -1;
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (nums[mid] == target) {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        ans = mid;
                        break;
                    } else {
                        low = mid + 1;
                    }
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return ans;
        }
    }
}
