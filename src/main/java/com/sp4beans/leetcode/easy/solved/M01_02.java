package com.sp4beans.leetcode.easy.solved;

//        给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
//        示例 1：
//
//        输入: s1 = "abc", s2 = "bca"
//        输出: true
//        示例 2：
//
//        输入: s1 = "abc", s2 = "bad"
//        输出: false
//        说明：
//
//        0 <= len(s1) <= 100
//        0 <= len(s2) <= 100

import java.util.Arrays;

public class M01_02 {

    private class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1 == null || s2 == null) {
                return s1 == s2;
            }
            if (s1.length() != s2.length()) {
                return false;
            }
            char[] cs1 = s1.toCharArray();
            char[] cs2 = s2.toCharArray();
            Arrays.sort(cs1);
            Arrays.sort(cs2);
            for (int i = 0; i < cs1.length; i++) {
                if (cs1[i] != cs2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

}
