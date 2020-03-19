package com.sp4beans.leetcode.hard;

//        假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
//        ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
//        请找出其中最小的元素。
//
//        注意数组中可能存在重复的元素。
//
//        示例 1：
//
//        输入: [1,3,5]
//        输出: 1
//        示例 2：
//
//        输入: [2,2,2,0,1]
//        输出: 0

public class P154 {

    private static class Solution {
        public int findMin(int[] nums) {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{2,2,2,4,2,2,2,2,2,2,2,2,2,2}));
        System.out.println(solution.findMin(new int[]{2,2,2,0,2,2,2,2,2,2,2,2,2,2}));
        System.out.println(solution.findMin(new int[]{2,2,2,0,1}));
    }
}
