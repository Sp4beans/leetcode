package com.sp4beans.leetcode.easy.solved;

//        给你一个整数数组 A，请找出并返回在该数组中仅出现一次的最大整数。
//
//        如果不存在这个只出现一次的整数，则返回 -1。
//
//         
//
//        示例 1：
//
//        输入：[5,7,3,9,4,9,8,3,1]
//        输出：8
//        解释：
//        数组中最大的整数是 9，但它在数组中重复出现了。而第二大的整数是 8，它只出现了一次，所以答案是 8。
//        示例 2：
//
//        输入：[9,9,8,8]
//        输出：-1
//        解释：
//        数组中不存在仅出现一次的整数。
//         
//
//        提示：
//
//        1 <= A.length <= 2000
//        0 <= A[i] <= 1000

public class P1133 {
    private static class Solution {
        public int largestUniqueNumber(int[] A) {

            int[] tmp = new int[1001];

            for (int a : A) {
                tmp[a]++;
            }

            for (int i = 1000; i >= 0; i--) {
                if (tmp[i] == 1) return i;
            }
            return -1;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.largestUniqueNumber(new int[]{5, 7, 3, 9, 4, 9, 8, 3, 1}));
        System.out.println(solution.largestUniqueNumber(new int[]{9, 9, 8, 8}));
    }
}
