package com.sp4beans.leetcode.easy.solved;

//        请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//         
//
//        示例 1：
//
//        输入：s = "We are happy."
//        输出："We%20are%20happy."
//         
//
//        限制：
//
//        0 <= s 的长度 <= 10000

public class M05 {

    private class Solution {
        public String replaceSpace(String s) {
            String replace = "%20";
            char[] cs = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : cs) {
                if (c == ' ') {
                    sb.append(replace);
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

}
