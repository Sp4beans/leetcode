package com.sp4beans.leetcode.medium.solved;

//        实现一个带有buildDict, 以及 search方法的魔法字典。
//
//        对于buildDict方法，你将被给定一串不重复的单词来构建一个字典。
//
//        对于search方法，你将被给定一个单词，并且判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
//
//        示例 1:
//
//        Input: buildDict(["hello", "leetcode"]), Output: Null
//        Input: search("hello"), Output: False
//        Input: search("hhllo"), Output: True
//        Input: search("hell"), Output: False
//        Input: search("leetcoded"), Output: False
//        注意:
//
//        你可以假设所有输入都是小写字母 a-z。
//        为了便于竞赛，测试所用的数据量很小。你可以在竞赛结束后，考虑更高效的算法。
//        请记住重置MagicDictionary类中声明的类变量，因为静态/类变量会在多个测试用例中保留。 请参阅这里了解更多详情。

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P676 {
    private static class MagicDictionary {

        Map<String, Integer> dictionary;
        Set<String> raw;
        /** Initialize your data structure here. */
        public MagicDictionary() {
            dictionary = new HashMap<>();
            raw = new HashSet<>();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for (String word : dict) {
                raw.add(word);
                char[] cs = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char temp = cs[i];
                    cs[i] = '*';
                    String newStr = new String(cs);
                    if (dictionary.containsKey(newStr)) {
                        dictionary.put(newStr, dictionary.get(newStr) + 1);
                    } else {
                        dictionary.put(newStr, 1);
                    }
                    cs[i] = temp;
                }
            }
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            boolean isRaw = raw.contains(word);
            char[] cs = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char temp = cs[i];
                cs[i] = '*';
                String newStr = new String(cs);
                int count = dictionary.getOrDefault(newStr, 0);
                if (isRaw && count > 1) {
                    return true;
                }
                if (!isRaw && count > 0) {
                    return true;
                }
                cs[i] = temp;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        MagicDictionary obj = new MagicDictionary();
        obj.buildDict(new String[]{"hahaha"});
        System.out.println(obj.search("hahaha"));

    }

    /**
     * Your MagicDictionary object will be instantiated and called as such:
     * MagicDictionary obj = new MagicDictionary();
     * obj.buildDict(dict);
     * boolean param_2 = obj.search(word);
     */
}
