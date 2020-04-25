package com.sp4beans.leetcode.medium.solved;

//        递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
//
//        示例1:
//
//        输入：A = 1, B = 10
//        输出：10
//        示例2:
//
//        输入：A = 3, B = 4
//        输出：12
//        提示:
//
//        保证乘法范围不会溢出

public class M08_05 {
    private static class Solution {
        public int multiply(int A, int B) {
            boolean neg = false;
            if (A < 0 || B < 0) {
                A = -A;
                B = -B;
            } else if (B < 0) {
                neg = true;
                B = -B;
            }

            if (B <= 1 && B >= 0) {
                return A;
            }
            if (B % 2 == 0) {
                return neg ? (-multiply(A, B/2) - multiply(A, B/2))
                        : (multiply(A, B/2) + multiply(A, B/2));
            } else {
                return neg ? (-multiply(A, (B-1)/2) - multiply(A, (B-1)/2) - A)
                        :  (multiply(A, (B-1)/2) + multiply(A, (B-1)/2) + A);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply(1, 10));
        System.out.println(solution.multiply(3, 4));
        System.out.println(solution.multiply(-3, 4));
        System.out.println(solution.multiply(3, -4));
        System.out.println(solution.multiply(-3, -4));
    }
}
