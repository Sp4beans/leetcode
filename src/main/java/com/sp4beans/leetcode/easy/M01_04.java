package com.sp4beans.leetcode.easy;

//        给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
//
//        回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
//
//        回文串不一定是字典当中的单词。
//
//         
//
//        示例1：
//
//        输入："tactcoa"
//        输出：true（排列有"tacocat"、"atcocta"，等等）

public class M01_04 {
    private class Solution {
        public boolean canPermutePalindrome(String s) {
            int[] count = new int[256];
            for (char c : s.toCharArray()) {
                count[c]++;
            }
            int countEven = 0;
            for (int i : count) {
                if (i % 2 == 1) {
                    countEven ++;
                }
                if (countEven >= 2) {
                    return false;
                }
            }
            return true;
        }
    }
}
