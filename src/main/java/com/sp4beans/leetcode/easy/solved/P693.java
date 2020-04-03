package com.sp4beans.leetcode.easy.solved;

//        给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
//
//        示例 1:
//
//        输入: 5
//        输出: True
//        解释:
//        5的二进制数是: 101
//        示例 2:
//
//        输入: 7
//        输出: False
//        解释:
//        7的二进制数是: 111
//        示例 3:
//
//        输入: 11
//        输出: False
//        解释:
//        11的二进制数是: 1011
//         示例 4:
//
//        输入: 10
//        输出: True
//        解释:
//        10的二进制数是: 1010

//          0 1 10 101 1010 10101 101010 1010101
//          0 1  2   5   10    21

public class P693 {
    private static class Solution {
        public boolean hasAlternatingBits(int n) {
            if (n == 0 || n == 1 || n == 2) {
                return true;
            }
            if ((n % 2) == 0 && (n / 2) % 2 == 1) {
                return hasAlternatingBits(n / 2);
            } else if (n % 2 == 1 && (n - 1) / 2 % 2 == 0) {
                return hasAlternatingBits((n - 1) / 2);
            }
            return false;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.hasAlternatingBits(5));
        System.out.println(solution.hasAlternatingBits(4));
        System.out.println(solution.hasAlternatingBits(7));
        System.out.println(solution.hasAlternatingBits(11));
        System.out.println(solution.hasAlternatingBits(10));
    }
}
