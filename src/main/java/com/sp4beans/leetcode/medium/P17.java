package com.sp4beans.leetcode.medium;

//        给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//        示例:
//
//        输入："23"
//        输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//        说明:
//        尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

import java.util.ArrayList;
import java.util.List;

public class P17 {
    private class Solution {
        String[] phone = new String[]{
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        List<String> output = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() != 0) {
                add("", digits);
            }
            return output;
        }

        public void add(String ans, String next) {
            if (null == next || next.length() == 0) {
                output.add(ans);
                return;
            }

            char digit = next.charAt(0);
            String letters = phone[digit - '0'];
            if (letters.length() == 0) {
                add(ans, next.substring(1));
            } else {
                for (char c : letters.toCharArray()) {
                    add(ans + c, next.substring(1));
                }
            }
        }
    }
}
