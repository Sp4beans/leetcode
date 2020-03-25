package com.sp4beans.leetcode.medium;

//        我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//
//         
//
//        示例:
//
//        输入: n = 10
//        输出: 12
//        解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//        说明:  
//
//        1 是丑数。
//        n 不超过1690。

public class M49 {
    private static class Solution {
        public int nthUglyNumber(int n) {
            int[] nth = new int[n + 1];
            nth[0] = 1;
            nth[1] = 1;
            int i2 = 1, i3 =1, i5 = 1;
            for (int i = 2; i <= n; i ++) {
                int val2 = nth[i2] * 2;
                int val3 = nth[i3] * 3;
                int val5 = nth[i5] * 5;
                int newVal = Math.min(Math.min(val2, val3), val5);
                if (newVal == val2) {
                    i2++;
                }
                if (newVal == val3) {
                    i3++;
                }
                if (newVal == val5) {
                    i5++;
                }
                nth[i] = newVal;
            }

            return nth[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(1));
        System.out.println(solution.nthUglyNumber(10));
    }
}
