package com.sp4beans.leetcode.medium;

//        给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
//
//        （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
//
//        示例 1:
//
//        输入: N = 10
//        输出: 9
//        示例 2:
//
//        输入: N = 1234
//        输出: 1234
//        示例 3:
//
//        输入: N = 332
//        输出: 299
//        说明: N 是在 [0, 10^9] 范围内的一个整数。

public class P783 {
    private static class Solution {
        public int monotoneIncreasingDigits(int N) {
            int len = String.valueOf(N).length();
            int base = 1;
            for (int i = 0; i < len - 1; i++) {
                base *= 10;
                int rest = N % base;
                int numI = getIdx(N, i);
                int numJ = getIdx(N, i + 1);
                if (numI < numJ) {
                    N = N - rest - 1;
                }
            }
            return N;
        }

        public int getIdx(int n, int idx) {
            int base = 1;
            while (idx-- > 0) {
                base *= 10;
            }
            return n % (base * 10) / base;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.monotoneIncreasingDigits(10));
        System.out.println(solution.monotoneIncreasingDigits(1234));
        System.out.println(solution.monotoneIncreasingDigits(332));
        System.out.println(solution.monotoneIncreasingDigits(234234234));
        System.out.println(solution.monotoneIncreasingDigits(989));
        System.out.println(solution.monotoneIncreasingDigits(879));
        System.out.println(solution.monotoneIncreasingDigits(987654321));
    }
}
