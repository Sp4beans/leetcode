package com.sp4beans.leetcode.easy;

//        给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
//        说明：
//
//        你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
//        示例 1:
//
//        输入: [2,2,1]
//        输出: 1
//        示例 2:
//
//        输入: [4,1,2,1,2]
//        输出: 4

public class P136 {

    private static class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result ^= num;
            }
            return result;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.print(solution.singleNumber(new int[]{2, 2, 1}));
        System.out.print(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

}
