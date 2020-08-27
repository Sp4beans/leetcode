package com.sp4beans.leetcode.easy;

//        给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
//
//        请你找到这个数组里第 k 个缺失的正整数。
//
//         
//
//        示例 1：
//
//        输入：arr = [2,3,4,7,11], k = 5
//        输出：9
//        解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
//        示例 2：
//
//        输入：arr = [1,2,3,4], k = 2
//        输出：6
//        解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
//         
//
//        提示：
//
//        1 <= arr.length <= 1000
//        1 <= arr[i] <= 1000
//        1 <= k <= 1000
//        对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j] 

public class P1539 {
    private static class Solution {
        public int findKthPositive(int[] arr, int k) {
            int base = 1;
            int idx = 0;
            while (k > 0 && idx < arr.length) {
                int cur = arr[idx];
                if (base < cur) {
                    k--;
                } else {
                    idx++;
                }
                base++;
            }
            while (k-- > 0) {
                base++;
            }
            return base - 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthPositive(new int[] {2, 3, 4, 7, 11}, 5));
        System.out.println(solution.findKthPositive(new int[] {1, 2, 3, 4}, 2));
        System.out.println(solution.findKthPositive(new int[] {1, 2}, 1));
    }
}
