package com.sp4beans.leetcode.easy;

//        给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
//
//        这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
//
//        示例1:
//
//        输入: pattern = "abba", str = "dog cat cat dog"
//        输出: true
//        示例 2:
//
//        输入:pattern = "abba", str = "dog cat cat fish"
//        输出: false
//        示例 3:
//
//        输入: pattern = "aaaa", str = "dog cat cat dog"
//        输出: false
//        示例 4:
//
//        输入: pattern = "abba", str = "dog dog dog dog"
//        输出: false
//        说明:
//        你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    

import java.util.HashSet;
import java.util.Set;

public class P290 {
    private static class Solution {
        public boolean wordPattern(String pattern, String str) {

            char[] source = pattern.toCharArray();
            String[] target = str.split(" ");
            if (source.length != target.length) {
                return false;
            }

            String[] pat2str = new String[26];
            Set<String> exist = new HashSet<>();

            for (int i = 0; i < source.length; i++) {
                if (pat2str[source[i] - 'a'] != null && !target[i].equals(pat2str[source[i] - 'a'])) {
                    return false;
                } else if (pat2str[source[i] - 'a'] == null) {
                    if (exist.contains(target[i])) {
                        return false;
                    }
                    pat2str[source[i] - 'a'] = target[i];
                    exist.add(target[i]);
                }
            }
            return true;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
    }
}
