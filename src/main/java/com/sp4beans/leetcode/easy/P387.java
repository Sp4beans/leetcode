package com.sp4beans.leetcode.easy;

//        给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//        案例:
//
//        s = "leetcode"
//        返回 0.
//
//        s = "loveleetcode",
//        返回 2.
//         
//
//        注意事项：您可以假定该字符串只包含小写字母。

public class P387 {
    private static class Solution {
        public int firstUniqChar(String s) {
            int[] count = new int[26];
            char[] source = s.toCharArray();
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i = 0; i < source.length; i++) {
                if (count[source[i] - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
    }
}
