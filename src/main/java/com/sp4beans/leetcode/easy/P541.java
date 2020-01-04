package com.sp4beans.leetcode.easy;

//        给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
//
//        示例:
//
//        输入: s = "abcdefg", k = 2
//        输出: "bacdfeg"
//        要求:
//
//        该字符串只包含小写的英文字母。
//        给定字符串的长度和 k 在[1, 10000]范围内。

public class P541 {
    private static class Solution {
        public String reverseStr(String s, int k) {
            char[] data = s.toCharArray();
            int times = 0;
            while (times * k < s.length()) {
                reverse(data, k * times, k * (times + 1) - 1);
                times += 2;
            }
            return new String(data);
        }

        public void reverse(char[] data, int start, int end) {
            end = Integer.min(data.length - 1, end);
            while (start < end) {
                char tmp = data[start];
                data[start] = data[end];
                data[end] = tmp;
                start++;
                end--;
            }
        }

    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.reverseStr("abcdefg", 2));
    }

}
