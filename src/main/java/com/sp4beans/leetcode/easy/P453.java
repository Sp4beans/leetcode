package com.sp4beans.leetcode.easy;

//        给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
//
//        示例:
//
//        输入:
//        [1,2,3]
//         2,1,0 --> 3
//         3,2,1 --> 6

//        [1,3,3] -> [2,3,4] -> [3,4,4] -> [4,4,5] -> [5,5,5]
//         2,0,0 --> 2
//         3,1,1 --> 5
//         4,2,2 --> 8
//        输出:
//        3
//
//        解释:
//        只需要3次移动（注意每次移动会增加两个元素的值）：
//
//        [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

public class P453 {

    private static class Solution {
        public int minMoves(int[] nums) {
            int min = Integer.MAX_VALUE, sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (nums[i] < min) {
                    min = nums[i];
                }
            }
            return sum - min * nums.length;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.minMoves(new int[]{1, 2, 3}));
        System.out.println(solution.minMoves(new int[]{1, 3, 3}));
        System.out.println(solution.minMoves(new int[]{-100, 0, 100}));
    }
}
