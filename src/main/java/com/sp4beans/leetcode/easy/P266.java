package com.sp4beans.leetcode.easy;

//        给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
//
//        示例 1：
//
//        输入: "code"
//        输出: false
//        示例 2：
//
//        输入: "aab"
//        输出: true
//        示例 3：
//
//        输入: "carerac"
//        输出: true

public class P266 {
    private static class Solution {
        public boolean canPermutePalindrome(String s) {
            int[] tmp = new int[52];
            for (char c : s.toCharArray()) {
                if (c >= 'a' && c <= 'z')
                    tmp[c - 'a']++;
                if (c >= 'A' && c <= 'Z')
                    tmp[c - 'A' + 26]++;
            }
            int count = 0;
            for (int t : tmp) {
                if (t % 2 == 1) count++;
            }
            return count < 2;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.canPermutePalindrome("code"));
        System.out.println(solution.canPermutePalindrome("aab"));
        System.out.println(solution.canPermutePalindrome("carerac"));
    }

}
