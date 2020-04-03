package com.sp4beans.leetcode.easy.solved;

//        给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
//
//        示例:
//        假设 words = ["practice", "makes", "perfect", "coding", "makes"]
//
//        输入: word1 = “coding”, word2 = “practice”
//        输出: 3
//        输入: word1 = "makes", word2 = "coding"
//        输出: 1
//        注意:
//        你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。

import java.util.ArrayList;
import java.util.List;

public class P243 {
    private static class Solution {
        public int shortestDistance(String[] words, String word1, String word2) {
            List<Integer> idx1 = new ArrayList<>();
            List<Integer> idx2 = new ArrayList<>();

            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) idx1.add(i);
                if (words[i].equals(word2)) idx2.add(i);
            }

            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < idx1.size(); i++) {
                for (int j = 0; j < idx2.size(); j++) {
                    int dis = Math.abs(idx1.get(i) - idx2.get(j));
                    if (dis < ans) ans = dis;
                }
            }

            return ans;
        }
    }
}
