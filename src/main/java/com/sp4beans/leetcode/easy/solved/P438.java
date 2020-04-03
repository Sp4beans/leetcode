package com.sp4beans.leetcode.easy.solved;

//        给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
//        字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//
//        说明：
//
//        字母异位词指字母相同，但排列不同的字符串。
//        不考虑答案输出的顺序。
//        示例 1:
//
//        输入:
//        s: "cbaebabacd" p: "abc"
//
//        输出:
//        [0, 6]
//
//        解释:
//        起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//        起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
//         示例 2:
//
//        输入:
//        s: "abab" p: "ab"
//
//        输出:
//        [0, 1, 2]
//
//        解释:
//        起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//        起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//        起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

import java.util.ArrayList;
import java.util.List;

public class P438 {
    private static class Solution {
        int[] count = new int[26];
        int[] targetCount = new int[26];

        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            char[] ss = s.toCharArray();
            for (char c : p.toCharArray()) {
                count[c - 'a']++;
            }

            int windowLength = p.length();
            int start = 0;
            int end = 0;
            while (end < s.length()) {
                if (end - start + 1 < windowLength) {
                    targetCount[ss[end] - 'a']++;
                    end++;
                } else if (end - start + 1 == windowLength) {
                    targetCount[ss[end] - 'a']++;
                    if (isEqual()) {
                        result.add(start);
                    }
                    targetCount[ss[start] - 'a']--;
                    start++;
                    end++;
                }
            }

            return result;
        }

        public boolean isEqual() {
            for (int i = 0; i < 26; i++) {
                if (count[i] != targetCount[i]) {
                    return false;
                }
            }
            return true;
        }
    }


    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.findAnagrams("abab", "ab");
    }
}
