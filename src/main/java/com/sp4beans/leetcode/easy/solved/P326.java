package com.sp4beans.leetcode.easy.solved;

//        给定一个整数，写一个函数来判断它是否是 3 的幂次方。
//
//        示例 1:
//
//        输入: 27
//        输出: true
//        示例 2:
//
//        输入: 0
//        输出: false
//        示例 3:
//
//        输入: 9
//        输出: true
//        示例 4:
//
//        输入: 45
//        输出: false
//        进阶：
//        你能不使用循环或者递归来完成本题吗？

public class P326 {
    private static class Solution {
        public boolean isPowerOfThree(int n) {
            return n > 0 && 1162261467 % n == 0;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree(27));
        System.out.println(solution.isPowerOfThree(0));
        System.out.println(solution.isPowerOfThree(9));
        System.out.println(solution.isPowerOfThree(45));
    }
}
