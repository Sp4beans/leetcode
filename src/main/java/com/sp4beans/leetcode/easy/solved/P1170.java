package com.sp4beans.leetcode.easy.solved;

//        我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
//
//        例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
//
//        现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
//
//         
//
//        示例 1：
//
//        输入：queries = ["cbd"], words = ["zaaaz"]
//        输出：[1]
//        解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
//        示例 2：
//
//        输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
//        输出：[1,2]
//        解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
//         
//
//        提示：
//
//        1 <= queries.length <= 2000
//        1 <= words.length <= 2000
//        1 <= queries[i].length, words[i].length <= 10
//        queries[i][j], words[i][j] 都是小写英文字母

public class P1170 {
    private class Solution {
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int[] fOfQueries = new int[queries.length];
            int[] fOfWords = new int[words.length];

            for (int i = 0; i < queries.length; i++) {
                fOfQueries[i] = func(queries[i]);
            }
            for (int i = 0; i < words.length; i++) {
                fOfWords[i] = func(words[i]);
            }

            int[] ans = new int[queries.length];
            for (int i = 0; i < fOfQueries.length; i++) {
                for (int j = 0; j < fOfWords.length; j++) {
                    if (fOfQueries[i] < fOfWords[j]) {
                        ans[i]++;
                    }
                }
            }
            return ans;
        }

        public int func(String str) {
            int[] ans = new int[26];
            for (char c : str.toCharArray()) {
                ans[c - 'a']++;
            }
            for (int an : ans) {
                if (0 != an) return an;
            }
            return 0;
        }
    }
}
