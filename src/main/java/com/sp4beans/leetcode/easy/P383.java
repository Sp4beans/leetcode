package com.sp4beans.leetcode.easy;

//        给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
//
//        (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
//
//        注意：
//
//        你可以假设两个字符串均只含有小写字母。
//
//        canConstruct("a", "b") -> false
//        canConstruct("aa", "ab") -> false
//        canConstruct("aa", "aab") -> true

public class P383 {

    private static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] source = new int[26];
            int[] mag = new int[26];
            for (char c : ransomNote.toCharArray()) {
                source[c - 'a']++;
            }
            for (char c : magazine.toCharArray()) {
                mag[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (source[i] > mag[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("a", "b"));
        System.out.println(solution.canConstruct("aa", "ab"));
        System.out.println(solution.canConstruct("aa", "aab"));
    }

}
