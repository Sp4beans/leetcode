package com.sp4beans.leetcode.easy;

//        编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
//
//        示例 1:
//
//        输入: "hello"
//        输出: "holle"
//        示例 2:
//
//        输入: "leetcode"
//        输出: "leotcede"
//        说明:
//        元音字母不包含字母"y"。

public class P345 {
    private static class Solution {
        public String reverseVowels(String s) {
            int start = 0;
            int end = s.length() - 1;
            char[] chars = s.toCharArray();
            while (end > start) {
                if (isTarget(chars[start]) && isTarget(chars[end])) {
                    char tmp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = tmp;
                    start++;
                    end--;
                } else {
                    if (!isTarget(chars[start])) {
                        start++;
                    }
                    if (!isTarget(chars[end])) {
                        end--;
                    }
                }
            }
            return new String(chars);
        }

        public boolean isTarget(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                    || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels("hello"));
        System.out.println(solution.reverseVowels("leetcode"));
    }
}
