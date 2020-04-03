package com.sp4beans.leetcode.easy.solved;

//        给定一个整数，将其转化为7进制，并以字符串形式输出。
//
//        示例 1:
//
//        输入: 100
//        输出: "202"
//        示例 2:
//
//        输入: -7
//        输出: "-10"
//        注意: 输入范围是 [-1e7, 1e7] 。

public class P504 {
    private static class Solution {
        public String convertToBase7(int num) {
            boolean flag = false;
            if (num < 0) {
                flag = true;
                num = -num;
            } else if (num == 0) {
                return "0";
            }

            StringBuilder result = new StringBuilder();
            while (num > 0) {
                result.append(num % 7);
                num /= 7;
            }
            if (flag) {
                result.append("-");
            }
            return result.reverse().toString();
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.convertToBase7(100));
        System.out.println(solution.convertToBase7(-7));
    }
}
