package com.sp4beans.leetcode.easy.solved;

//        给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
//
//        示例：
//
//        给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
//            tmps = [-2, -2, 1, -4, -2, -3]
//        sumRange(0, 2) -> 1
//        sumRange(2, 5) -> -1
//        sumRange(0, 5) -> -3
//        说明:
//
//        你可以假设数组不可变。
//        会多次调用 sumRange 方法。


public class P303 {

    private class NumArray {

        int[] tmp;

        public NumArray(int[] nums) {
            tmp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    tmp[i] = nums[i];
                } else {
                    tmp[i] = nums[i] + tmp[i - 1];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return tmp[j];
            } else {
                return tmp[j] - tmp[i - 1];
            }
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}