package com.sp4beans.leetcode.easy;

//        统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
//
//        请注意，你可以假定字符串里不包括任何不可打印的字符。
//
//        示例:
//
//        输入: "Hello, my name is John"
//        输出: 5

public class P434 {
    private static class Solution {
        public int countSegments(String s) {
            String[] ss = s.split(" ");
            int count = 0;
            for (String sss : ss) {
                if (null != sss && sss.trim().length() > 0) {
                    count++;
                }
            }
            return count;
        }
    }
}
