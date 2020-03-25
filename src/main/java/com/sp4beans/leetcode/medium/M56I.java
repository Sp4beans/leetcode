package com.sp4beans.leetcode.medium;

//        一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
//
//         
//
//        示例 1：
//
//        输入：nums = [4,1,4,6]
//        输出：[1,6] 或 [6,1]
//        示例 2：
//
//        输入：nums = [1,2,10,4,1,4,3,3]
//        输出：[2,10] 或 [10,2]
//         
//
//        限制：
//
//        2 <= nums <= 10000

public class M56I {

    private static class Solution {
        public int[] singleNumbers(int[] nums) {

            int tmp = 0;
            for (int num : nums) {
                tmp ^= num;
            }

            int i = 0;
            while ((tmp & (1 << i)) == 0) {
                i++;
            }

            int ans0 = tmp;
            int ans1 = tmp;
            for (int num : nums) {
                if ((num & (1 << i)) == 0) {
                    ans0 ^= num;
                } else {
                    ans1 ^= num;
                }
            }

            return new int[]{ans0, ans1};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.singleNumbers(new int[]{1 ,2, 5, 2});
    }

}
