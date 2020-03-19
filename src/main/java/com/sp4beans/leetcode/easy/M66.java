package com.sp4beans.leetcode.easy;

//        给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
//
//         
//
//        示例:
//
//        输入: [1,2,3,4,5]
//        输出: [120,60,40,30,24]
//         
//
//        提示：
//
//        所有元素乘积之和不会溢出 32 位整数
//        a.length <= 100000

public class M66 {
    private class Solution {
        public int[] constructArr(int[] nums) {
            int length = nums.length;
            int[] left = new int[length];
            int[] right = new int[length];

            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    left[i] = nums[i];
                } else {
                    left[i] = nums[i] * left[i-1];
                }

                if (i == 0) {
                    right[length - i - 1] = nums[length - i - 1];
                } else {
                    right[length - i - 1] = nums[length - i - 1] * right[length - i];
                }
            }

            int[] ans = new int[length];
            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    ans[i] = right[i + 1];
                } else if (i == length - 1) {
                    ans[i] = left[i - 1];
                } else {
                    ans[i] = left[i - 1] * right[i + 1];
                }
            }

            return ans;
        }
    }
}
