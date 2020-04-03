package com.sp4beans.leetcode.easy.solved;

//        把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
//
//        示例 1：
//
//        输入：[3,4,5,1,2]
//        输出：1
//        示例 2：
//
//        输入：[2,2,2,0,1]
//        输出：0

public class M11 {
    private class Solution {
        public int minArray(int[] nums) {
            int low = 0;
            int high = nums.length - 1;
            return findMin(nums, low, high);
        }

        private int findMin(int[] nums, int low, int high) {
            while(low < high) {
                if (nums[low] < nums[high]) {
                    return nums[low];
                }

                int mid = (low + high) >> 1;
                if (nums[mid] == nums[high] && nums[low] == nums[mid]) {
                    return Math.min(findMin(nums, low, mid), findMin(nums, mid + 1, high));
                }

                if (nums[mid] >= nums[low]) {
                    low = mid + 1;
                } else if (nums[mid] <= nums[high]) {
                    high = mid;
                } else {
                    return Math.min(nums[low], nums[high]);
                }
            }
            return nums[high];
        }
    }
}
