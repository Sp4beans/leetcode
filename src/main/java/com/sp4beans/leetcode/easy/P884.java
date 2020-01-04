package com.sp4beans.leetcode.easy;

//        给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
//
//        如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
//
//        返回所有不常用单词的列表。
//
//        您可以按任何顺序返回列表。
//
//         
//
//        示例 1：
//
//        输入：A = "this apple is sweet", B = "this apple is sour"
//        输出：["sweet","sour"]
//        示例 2：
//
//        输入：A = "apple apple", B = "banana"
//        输出：["banana"]
//         
//
//        提示：
//
//        0 <= A.length <= 200
//        0 <= B.length <= 200
//        A 和 B 都只包含空格和小写字母。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P884 {
    private class Solution {
        public String[] uncommonFromSentences(String A, String B) {
            HashMap<String, Integer> seta = new HashMap<>();
            HashMap<String, Integer> setb = new HashMap<>();

            for (String a : A.split(" ")) {
                if (seta.containsKey(a)) {
                    seta.put(a, seta.get(a) + 1);
                } else {
                    seta.put(a, 1);
                }
            }
            for (String a : B.split(" ")) {
                if (setb.containsKey(a)) {
                    setb.put(a, setb.get(a) + 1);
                } else {
                    setb.put(a, 1);
                }
            }

            List<String> result = new ArrayList<>();
            for (String key : seta.keySet()) {
                if (seta.get(key) == 1 && !setb.containsKey(key)) {
                    result.add(key);
                }
            }
            for (String key : setb.keySet()) {
                if (setb.get(key) == 1 && !seta.containsKey(key)) {
                    result.add(key);
                }
            }

            return result.toArray(new String[result.size()]);
        }
    }
}
