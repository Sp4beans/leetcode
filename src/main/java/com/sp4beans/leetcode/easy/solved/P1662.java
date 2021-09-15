package com.sp4beans.leetcode.easy.solved;

//        给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
//
//        数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
//
//         
//
//        示例 1：
//
//        输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
//        输出：true
//        解释：
//        word1 表示的字符串为 "ab" + "c" -> "abc"
//        word2 表示的字符串为 "a" + "bc" -> "abc"
//        两个字符串相同，返回 true
//        示例 2：
//
//        输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
//        输出：false
//        示例 3：
//
//        输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//        输出：true
//         
//
//        提示：
//
//        1 <= word1.length, word2.length <= 103
//        1 <= word1[i].length, word2[i].length <= 103
//        1 <= sum(word1[i].length), sum(word2[i].length) <= 103
//        word1[i] 和 word2[i] 由小写字母组成

import java.util.ArrayList;
import java.util.List;

public class P1662 {
    private class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            List<Character> cs1 = flat(word1);
            List<Character> cs2 = flat(word2);
            if (cs1.size() != cs2.size()) {
                return false;
            }

            for (int i = 0; i < cs1.size(); i++) {
                if (cs1.get(i) != cs2.get(i)) {
                    return false;
                }
            }

            return true;
        }

        private List<Character> flat(String[] word) {
            List<Character> res = new ArrayList<>();
            for (String wordItem : word) {
                for (char c : wordItem.toCharArray()) {
                    res.add(c);
                }
            }
            return res;
        }
    }
}
