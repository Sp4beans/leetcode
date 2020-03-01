package com.sp4beans.leetcode.easy;

//        数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//
//         
//
//        你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//         
//
//        示例 1:
//
//        输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//        输出: 2
//         
//
//        限制：
//
//        1 <= 数组长度 <= 50000
//
//         
//
//        注意：本题与主站 169 题相同

public class M39 {
    private static class Solution {
        public int majorityElement(int[] nums) {
            int result = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (count == 0) {
                    result = nums[i];
                    count++;
                    continue;
                }
                if (nums[i] == result) {
                    count++;
                } else {
                    count--;
                }
            }
            return result;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
