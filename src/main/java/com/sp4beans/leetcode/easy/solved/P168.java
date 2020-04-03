package com.sp4beans.leetcode.easy.solved;

//        给定一个正整数，返回它在 Excel 表中相对应的列名称。
//
//        例如，
//
//        1 -> A
//        2 -> B
//        3 -> C
//        ...
//        26 -> Z
//        27 -> AA
//        28 -> AB
//        ...
//        示例 1:
//
//        输入: 1
//        输出: "A"
//        示例 2:
//
//        输入: 28
//        输出: "AB"
//        示例 3:
//
//        输入: 701
//        输出: "ZY"

public class P168 {
    private static class Solution {
        public String convertToTitle(int n) {
            StringBuilder ans = new StringBuilder();
            while (n > 0) {
                int a = n % 26;
                if (a == 0) {
                    ans.append('Z');
                } else {
                    ans.append((char) (a + 'A' - 1));
                }
                n = (n - 1) / 26;
            }
            return ans.reverse().toString();
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.convertToTitle(1));
        System.out.println(solution.convertToTitle(28));
        System.out.println(solution.convertToTitle(701));
    }
}
