package com.sp4beans.leetcode.easy.solved;

//        统计所有小于非负整数 n 的质数的数量。
//
//        示例:
//
//        输入: 10
//        输出: 4
//        解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

public class P204 {
    private static class Solution {
        public int countPrimes(int n) {
            boolean[] isNotPrime = new boolean[n];
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (!isNotPrime[i]) {
                    isNotPrime[i] = false;
                    count++;
                    for (int j = 1; i * j < n; j++) {
                        isNotPrime[i * j] = true;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(10));
    }


}
