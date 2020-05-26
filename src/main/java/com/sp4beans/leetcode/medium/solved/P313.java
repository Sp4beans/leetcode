package com.sp4beans.leetcode.medium.solved;

//        编写一段程序来查找第 n 个超级丑数。
//
//        超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
//
//        示例:
//
//        输入: n = 12, primes = [2,7,13,19]
//        输出: 32
//        解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
//        说明:
//
//        1 是任何给定 primes 的超级丑数。
//         给定 primes 中的数字以升序排列。
//        0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
//        第 n 个超级丑数确保在 32 位有符整数范围内。

public class P313 {
    private static class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] nth = new int[n + 1];
            nth[0] = 1;
            nth[1] = 1;
            int[] idxs = new int[primes.length];
            for (int i = 0; i < idxs.length; i++) {
                idxs[i] = 1;
            }
            for (int i = 2; i <= n; i++) {
                int cur = Integer.MAX_VALUE;
                int minIdx = 0;
                for (int j = 0; j < primes.length; j++) {
                    int tmp = nth[idxs[j]] * primes[j];
                    if (tmp < cur) {
                        cur = tmp;
                        minIdx = j;
                    }
                }
                if (nth[i - 1] == cur) {
                    i--;
                } else {
                    nth[i] = cur;
                }
                idxs[minIdx]++;
            }
            return nth[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthSuperUglyNumber(12, new int[] {2, 7, 13, 19}));
    }
}
