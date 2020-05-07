package com.sp4beans.leetcode.medium.solved;

//        有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
//
//        示例：
//
//        输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
//        输出：1
//        提示：
//
//        words.length <= 100000

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class M17_11 {
    private class Solution {
        Map<String, Set<Integer>> map;

        public int findClosest(String[] words, String word1, String word2) {
            map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (map.containsKey(word)) {
                    map.get(word).add(i);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    map.put(word, set);
                }
            }

            Set<Integer> s1 = map.get(word1);
            Set<Integer> s2 = map.get(word2);
            int minLen = Integer.MAX_VALUE;
            for (int i : s1) {
                for (int j : s2) {
                    minLen = Math.min(minLen, Math.abs(i - j));
                }
            }
            return minLen;
        }
    }
}
