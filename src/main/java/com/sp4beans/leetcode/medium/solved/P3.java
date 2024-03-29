package com.sp4beans.leetcode.medium.solved;

//        给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//        示例 1:
//
//        输入: "abcabcbb"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//        示例 2:
//
//        输入: "bbbbb"
//        输出: 1
//        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//        示例 3:
//
//        输入: "pwwkew"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P3 {
    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int ans = 0;
            char[] ss = s.toCharArray();
            Set<Character> set = new HashSet<>();
            int start = 0;
            int end = 0;

            while (start < ss.length && end < ss.length) {
                if (start == end) {
                    set.add(ss[start]);
                    end++;
                } else {
                    if (!set.contains(ss[end])) {
                        set.add(ss[end]);
                        end++;
                    } else {
                        set.remove(ss[start]);
                        start++;
                    }
                }
                ans = Integer.max(ans, set.size());
            }
            return ans;
        }

        public int lengthOfLongestSubstring2(String s) {
            int ans = 0;
            char[] cs = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            int start = 0;
            int end = 0;
            while (start < cs.length && end < cs.length) {
                if (start == end) {
                    map.put(cs[start], start);
                } else {
                    if (map.containsKey(cs[end]) && map.get(cs[end]) >= start) {
                        start = map.get(cs[end]) + 1;
                    }
                    map.put(cs[end], end);
                }
                end++;
                ans = Math.max(ans, end - start);
            }
            return ans;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring2("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring2("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring2("dvdf"));
    }

}
