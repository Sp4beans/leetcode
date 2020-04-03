package com.sp4beans.leetcode.easy.solved;

//        给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
//        示例 1:
//
//        输入: "aba"
//        输出: True
//        示例 2:
//
//        输入: "abca"
//        输出: True
//        解释: 你可以删除c字符。
//        注意:
//
//        字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。

public class P680 {
    private static class Solution {
        public boolean validPalindrome(String s) {
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
                }
                start++;
                end--;
            }
            return true;
        }

        public boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("aba"));
        System.out.println(solution.validPalindrome("abca"));
    }

}
