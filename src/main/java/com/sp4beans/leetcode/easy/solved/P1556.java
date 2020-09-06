package com.sp4beans.leetcode.easy.solved;

//        给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
//
//         
//
//        示例 1：
//
//        输入：n = 987
//        输出："987"
//        示例 2：
//
//        输入：n = 1234
//        输出："1.234"
//        示例 3：
//
//        输入：n = 123456789
//        输出："123.456.789"
//        示例 4：
//
//        输入：n = 0
//        输出："0"
//         
//
//        提示：
//
//        0 <= n < 2^31

public class P1556 {
    private static class Solution {
        public String thousandSeparator(int n) {
            String ans = "";
            while (n / 1000 > 0) {
                int m = n % 1000;
                n = n / 1000;
                ans = String.format(".%03d", m) + ans;
            }
            ans = n + ans;
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.thousandSeparator(987));
        System.out.println(solution.thousandSeparator(1234));
        System.out.println(solution.thousandSeparator(123456789));
        System.out.println(solution.thousandSeparator(0));
        System.out.println(solution.thousandSeparator(51040));
    }
}
