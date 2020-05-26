package com.sp4beans.leetcode.hard;

//        给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
//
//        以任意顺序返回这两个数字均可。
//
//        示例 1:
//
//        输入: [1]
//        输出: [2,3]
//        示例 2:
//
//        输入: [2,3]
//        输出: [1,4]
//        提示：
//
//        nums.length <= 30000

public class M17_19 {
    private static class Solution {
        public int[] missingTwo(int[] nums) {
            int ans = 0;
            int length = nums.length + 2;
            for (int i = 1; i <= length; i++) {
                ans ^= i;
            }
            for (int num : nums) {
                ans ^= num;
            }

            int k = 0;
            while (((ans >> k) & 1) != 1) {
                k++;
            }

            int ans1 = 0;
            int ans2 = 0;
            for (int i = 1; i <= length; i++) {
                if (((i >> k) & 1) == 1) {
                    ans1 ^= i;
                } else {
                    ans2 ^= i;
                }
            }
            for (int num : nums) {
                if (((num >> k) & 1) == 1) {
                    ans1 ^= num;
                } else {
                    ans2 ^= num;
                }
            }
            return new int[] {ans1, ans2};

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.missingTwo(new int[] {1});
        solution.missingTwo(new int[] {2, 3});
        solution.missingTwo(new int[] {1, 2, 3, 4, 6, 7, 9, 10});
    }
}
