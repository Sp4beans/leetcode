package com.sp4beans.leetcode.easy.solved;

//        给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
//
//        示例:
//        输入: S = "a1b2"
//        输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
//
//        输入: S = "3z4"
//        输出: ["3z4", "3Z4"]
//
//        输入: S = "12345"
//        输出: ["12345"]
//        注意：
//
//        S 的长度不超过12。
//        S 仅由数字和字母组成。

import java.util.ArrayList;
import java.util.List;

public class P784 {
    private class Solution {
        List<String> result = new ArrayList<>();

        public List<String> letterCasePermutation(String S) {

            search(S, 0, "");
            return result;
        }

        public void search(String S, int index, String curS) {
            if (index == S.length()) {
                result.add(curS);
                return;
            }
            char c = S.charAt(index);
            if (c >= 'a' && c <= 'z') {
                search(S, index + 1, curS + c);
                search(S, index + 1, curS + (char) (c - 'a' + 'A'));
            } else if (c >= 'A' && c <= 'Z') {
                search(S, index + 1, curS + c);
                search(S, index + 1, curS + (char) (c - 'A' + 'a'));
            } else {
                search(S, index + 1, curS + c);
            }
        }
    }
}
