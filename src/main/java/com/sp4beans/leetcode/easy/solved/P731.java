package com.sp4beans.leetcode.easy.solved;

//        不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
//
//        示例 1:
//
//        输入: a = 1, b = 2
//        输出: 3
//        示例 2:
//
//        输入: a = -2, b = 3
//        输出: 1

public class P731 {
    private static class Solution {
        public int getSum(int a, int b) {
            while (b != 0) {
                int ans = (a ^ b);
                int eor = (a & b) << 1;
                a = ans;
                b = eor;
            }
            return a;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.getSum(1, 2));
        System.out.println(solution.getSum(-2, 3));
    }
}
