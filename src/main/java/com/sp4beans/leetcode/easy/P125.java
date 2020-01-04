package com.sp4beans.leetcode.easy;

//        给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
//        说明：本题中，我们将空字符串定义为有效的回文串。
//
//        示例 1:
//
//        输入: "A man, a plan, a canal: Panama"
//        输出: true
//        示例 2:
//
//        输入: "race a car"
//        输出: false

public class P125 {
    private static class Solution {
        public boolean isPalindrome(String s) {
            char[] ss = s.toCharArray();
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                boolean isLetterStart = Character.isLetter(ss[start]) || Character.isDigit(ss[start]);
                boolean isLetterEnd = Character.isLetter(ss[end]) || Character.isDigit(ss[end]);
                System.out.println(start + " " + end);
                if (isLetterEnd && isLetterStart) {
                    if (Character.toLowerCase(ss[start]) != Character.toLowerCase(ss[end])) {
                        return false;
                    } else {
                        start++;
                        end--;
                    }
                } else {
                    if (!isLetterStart) {
                        start++;
                    }
                    if (!isLetterEnd) {
                        end--;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("0P"));
    }
}
