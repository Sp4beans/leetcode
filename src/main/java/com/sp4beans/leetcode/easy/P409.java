package com.sp4beans.leetcode.easy;

//        给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
//
//        在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
//
//        注意:
//        假设字符串的长度不会超过 1010。
//
//        示例 1:
//
//        输入:
//        "abccccdd"
//
//        输出:
//        7
//
//        解释:
//        我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。

public class P409 {
    private static class Solution {
        public int longestPalindrome(String s) {
            boolean[] set = new boolean[256];
            int result = 0;
            for (char c : s.toCharArray()) {
                if (set[c]) {
                    set[c] = false;
                    result += 2;
                } else {
                    set[c] = true;
                }
            }
            boolean flag = false;
            for (int i = 0; i < set.length; i++) {
                if (set[i]) {
                    flag = true;
                    break;
                }
            }
            return flag ? 1 + result : result;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
    }
}
