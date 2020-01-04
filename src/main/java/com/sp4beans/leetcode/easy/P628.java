package com.sp4beans.leetcode.easy;

//        给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//
//        示例 1:
//
//        输入: [1,2,3]
//        输出: 6
//        示例 2:
//
//        输入: [1,2,3,4]
//        输出: 24
//        注意:
//
//        给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
//        输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。

import java.util.Arrays;

public class P628 {
    private static class Solution {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            int length = nums.length - 1;
            int ans = Math.max(nums[0] * nums[1] * nums[length], nums[length] * nums[length - 1] * nums[length - 2]);
            return ans;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.maximumProduct(new int[]{1, 2, 3}));
        System.out.println(solution.maximumProduct(new int[]{1, 2, 3, 4}));
        System.out.println(solution.maximumProduct(new int[]{-4, -3, -2, -1, 60}));
    }
}
