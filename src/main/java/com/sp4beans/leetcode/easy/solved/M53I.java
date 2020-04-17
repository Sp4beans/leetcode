package com.sp4beans.leetcode.easy.solved;

//        统计一个数字在排序数组中出现的次数。
//
//         
//
//        示例 1:
//
//        输入: nums = [5,7,7,8,8,10], target = 8
//        输出: 2
//        示例 2:
//
//        输入: nums = [5,7,7,8,8,10], target = 6
//        输出: 0
//         
//
//        限制：
//
//        0 <= 数组长度 <= 50000

public class M53I {
    private class Solution {
        public int search(int[] nums, int target) {
            int firstIndex = firstIndex(nums, target);
            if (firstIndex == -1) {
                return 0;
            }
            int lastIndex = lastIndex(nums, target);
            return lastIndex - firstIndex + 1;
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
