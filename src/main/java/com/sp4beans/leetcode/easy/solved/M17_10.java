package com.sp4beans.leetcode.easy.solved;

//        如果数组中多一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
//
//        示例 1：
//
//        输入：[1,2,5,9,5,9,5,5,5]
//        输出：5
//         
//
//        示例 2：
//
//        输入：[3,2]
//        输出：-1
//         
//
//        示例 3：
//
//        输入：[2,2,1,1,1,2,2]
//        输出：2
//         
//
//        说明：
//        你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？

public class M17_10 {
    private class Solution {
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
            return count == 0 ? -1 : result;
        }
    }
}
