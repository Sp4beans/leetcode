package com.sp4beans.leetcode.easy.solved;

//        给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
//        示例 1:
//
//        输入: s = "anagram", t = "nagaram"
//        输出: true
//        示例 2:
//
//        输入: s = "rat", t = "car"
//        输出: false
//        说明:
//        你可以假设字符串只包含小写字母。

public class P242 {
    private static class Solution {
        public boolean isAnagram(String s, String t) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                count[c - 'a']--;
            }
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }


    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
    }
}
