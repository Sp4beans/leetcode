package com.sp4beans.leetcode.easy.solved;

//        在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
//
//        示例:
//
//        s = "abaccdeff"
//        返回 "b"
//
//        s = ""
//        返回 " "
//         
//
//        限制：
//
//        0 <= s 的长度 <= 50000

import java.util.HashSet;
import java.util.Set;

public class M50 {

    private class Solution {
        public char firstUniqChar(String s) {
            Set<Character> shown = new HashSet<>();
            Set<Character> showOnce = new HashSet<>();
            char[] cs = s.toCharArray();
            for (char c : cs) {
                if (shown.contains(c)) {
                    showOnce.remove(c);
                } else {
                    shown.add(c);
                    showOnce.add(c);
                }
            }

            if (showOnce.isEmpty()) {
                return ' ';
            }

            for (char c : cs) {
                if (showOnce.contains(c)) {
                    return c;
                }
            }

            return ' ';
        }
    }
}
