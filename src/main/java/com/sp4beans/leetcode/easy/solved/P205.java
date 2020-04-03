package com.sp4beans.leetcode.easy.solved;

//        给定两个字符串 s 和 t，判断它们是否是同构的。
//
//        如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
//
//        所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
//
//        示例 1:
//
//        输入: s = "egg", t = "add"
//        输出: true
//        示例 2:
//
//        输入: s = "foo", t = "bar"
//        输出: false
//        示例 3:
//
//        输入: s = "paper", t = "title"
//        输出: true
//        说明:
//        你可以假设 s 和 t 具有相同的长度。

import java.util.HashMap;
import java.util.HashSet;

public class P205 {
    private static class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            HashSet<Character> used = new HashSet<>();
            HashMap<Character, Character> swap = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                if (swap.containsKey(s.charAt(i))) {
                    if (t.charAt(i) != swap.get(s.charAt(i))) {
                        return false;
                    }
                } else {
                    if (used.contains(t.charAt(i))) {
                        return false;
                    }
                    swap.put(s.charAt(i), t.charAt(i));
                    used.add(t.charAt(i));
                }

            }
            return true;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("egg", "add"));
        System.out.println(solution.isIsomorphic("foo", "bar"));
        System.out.println(solution.isIsomorphic("paper", "title"));
    }
}
