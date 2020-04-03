package com.sp4beans.leetcode.easy.solved;

//        指定年份 Y 和月份 M，请你帮忙计算出该月一共有多少天。
//
//         
//
//        示例 1：
//
//        输入：Y = 1992, M = 7
//        输出：31
//        示例 2：
//
//        输入：Y = 2000, M = 2
//        输出：29
//        示例 3：
//
//        输入：Y = 1900, M = 2
//        输出：28
//         
//
//        提示：
//
//        1583 <= Y <= 2100
//        1 <= M <= 12

public class P1118 {
    private static class Solution {
        public int numberOfDays(int Y, int M) {
            int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (M == 2) {
                return isY(Y) ? days[M] + 1 : days[M];
            }
            return days[M];
        }

        public boolean isY(int y) {
            if (y % 100 == 0) {
                return y % 400 == 0;
            } else {
                return y % 4 == 0;
            }
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfDays(1992, 7));
        System.out.println(solution.numberOfDays(2000, 2));
        System.out.println(solution.numberOfDays(1900, 2));
    }
}
