package com.sp4beans.leetcode.easy;

//        给你一个以行程长度编码压缩的整数列表 nums 。
//
//        考虑每相邻两个元素 [a, b] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后有 a 个值为 b 的元素。
//
//        请你返回解压后的列表。
//
//         
//
//        示例：
//
//        输入：nums = [1,2,3,4]
//        输出：[2,4,4,4]
//         
//
//        提示：
//
//        2 <= nums.length <= 100
//        nums.length % 2 == 0
//        1 <= nums[i] <= 100

public class P5143 {
    private class Solution {
        public int[] decompressRLElist(int[] nums) {
            int length = 0;
            for (int i = 0; i < nums.length; i+=2) {
                length += nums[i];
            }
            int[] result = new int[length];
            int index = 0;
            for (int i = 0; i < nums.length; i+=2) {
                for (int j = 0; j < nums[i]; j++) {
                    result[index++] = nums[i+1];
                }
            }
            return result;
        }
    }
}
