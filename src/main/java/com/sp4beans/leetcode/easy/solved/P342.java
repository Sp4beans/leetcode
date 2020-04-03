package com.sp4beans.leetcode.easy.solved;

//        给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
//
//        示例 1:
//
//        输入: 16
//        输出: true
//        示例 2:
//
//        输入: 5
//        输出: false
//        进阶：
//        你能不使用循环或者递归来完成本题吗？


public class P342 {
    private static class Solution {
        public boolean isPowerOfFour(int num) {
            return (num & 0xaaaaaaaa) == 0 && Integer.bitCount(num) == 1;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfFour(16));
        System.out.println(solution.isPowerOfFour(5));
    }
}
