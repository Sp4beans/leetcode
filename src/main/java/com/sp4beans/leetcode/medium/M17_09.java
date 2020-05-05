package com.sp4beans.leetcode.medium;

//        有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
//
//        示例 1:
//
//        输入: k = 5
//
//        输出: 9

public class M17_09 {
    private static class Solution {
        public int getKthMagicNumber(int n) {
            int[] nth = new int[n + 1];
            nth[0] = 1;
            nth[1] = 1;
            int i3 = 1, i5 =1, i7 = 1;
            for (int i = 2; i <= n; i ++) {
                int val3 = nth[i3] * 3;
                int val5 = nth[i5] * 5;
                int val7 = nth[i7] * 7;
                int newVal = Math.min(Math.min(val3, val5), val7);
                if (newVal == val3) {
                    i3++;
                }
                if (newVal == val5) {
                    i5++;
                }
                if (newVal == val7) {
                    i7++;
                }
                nth[i] = newVal;
            }

            return nth[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 10; i++) {
            System.out.println(solution.getKthMagicNumber(i));
        }
    }
}
