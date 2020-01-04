package com.sp4beans.leetcode.easy;

//        给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
//
//        举个例子，A = "abcd"，B = "cdabcdab"。
//
//        答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
//
//        注意:
//
//         A 与 B 字符串的长度在1和10000区间范围内。

public class P686 {
    private static class Solution {
        public int repeatedStringMatch(String A, String B) {
            if (null == A || A.length() == 0) {
                return -1;
            }
            String test = A;
            int count = 1;
            while (test.length() <= A.length() * 2 + B.length()) {
                if (test.indexOf(B) == -1) {
                    test += A;
                    count++;
                } else {
                    return count;
                }
            }
            return -1;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedStringMatch("abcd", "cdabcdab"));
    }

}
