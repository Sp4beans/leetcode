package com.sp4beans.leetcode.medium.solved;

//        给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
//
//        示例 1:
//
//        输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
//        输出: 16
//        解释: 这两个单词为 "abcw", "xtfn"。
//        示例 2:
//
//        输入: ["a","ab","abc","d","cd","bcd","abcd"]
//        输出: 4
//        解释: 这两个单词为 "ab", "cd"。
//        示例 3:
//
//        输入: ["a","aa","aaa","aaaa"]
//        输出: 0
//        解释: 不存在这样的两个单词。

public class P318 {

    private class Solution {
        public int maxProduct(String[] words) {
            int maxLength = 0;
            int length = words.length;
            int[] hashs = new int[length];
            for(int i = 0; i < length; i++) {
                hashs[i] = calcHash(words[i]);
            }
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    String a = words[i];
                    String b = words[j];
                    if (!hasCommonChar(hashs[i], hashs[j])) {
                        maxLength = Math.max(maxLength, a.length() * b.length());
                    }
                }
            }
            return maxLength;
        }

        private int calcHash(String c) {
            int ans = 0;
            for (char cc : c.toCharArray()) {
                int tmp = 1 << (cc - 'a');
                if ((ans & tmp) == 0) {
                    ans += tmp;
                }
            }
            return ans;
        }

        private boolean hasCommonChar(int a, int b) {
            return (a & b) != 0;
        }

    }
}
