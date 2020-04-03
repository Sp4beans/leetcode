package com.sp4beans.leetcode.easy.solved;

//        给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
//
//        若无答案，则返回空字符串。
//
//        示例 1:
//
//        输入:
//        words = ["w","wo","wor","worl", "world"]
//        输出: "world"
//        解释:
//        单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
//        示例 2:
//
//        输入:
//        words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//        输出: "apple"
//        解释:
//        "apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
//        注意:
//
//        所有输入的字符串都只包含小写字母。
//        words数组长度范围为[1,1000]。
//        words[i]的长度范围为[1,30]。

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P720 {
    private static class Solution {
        public String longestWord(String[] words) {
            Set<String> set = new HashSet<String>();
            Arrays.sort(words);

            String result = "";
            for (String word : words) {
                if (word.length() == 1) {
                    set.add(word);
                } else {
                    if (!set.contains(word.substring(0, word.length() - 1))) {
                        continue;
                    } else {
                        set.add(word);
                    }
                }
                if (word.length() > result.length()) {
                    result = word;
                }
            }
            return result;
        }

    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println(solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
}
