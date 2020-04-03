package com.sp4beans.leetcode.easy.solved;

//        给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
//
//        请你找到并返回这个整数
//
//        示例：
//
//        输入：arr = [1,2,2,6,6,6,6,7,10]
//        输出：6
//
//
//        提示：
//
//        1 <= arr.length <= 10^4
//        0 <= arr[i] <= 10^5

public class P1287 {

    private static class Solution {
        public int findSpecialInteger(int[] arr) {
            int ans = -1;
            int lastIndex = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != ans) {
                    if (lastIndex >= 0) {
                        int count = i - lastIndex;
                        if (count > arr.length / 4) {
                            return ans;
                        }
                    }
                    ans = arr[i];
                    lastIndex = i;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
    }
}
