package com.sp4beans.leetcode.easy;

//        给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
//
//        示例 1:
//
//        输入: [3,0,1]
//        输出: 2
//        示例 2:
//
//        输入: [9,6,4,2,3,5,7,0,1]
//        输出: 8
//        说明:
//        你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?

public class P268 {
    private static class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int ans = ((n) * (n + 1)) >> 1;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return ans - sum;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[]{3, 0, 1}));
        System.out.println(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

}
