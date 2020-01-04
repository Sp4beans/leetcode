package com.sp4beans.leetcode.easy;

//        实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
//
//         
//
//        示例 1：
//
//        输入:"Hello"
//        输出:"hello"
//        示例 2：
//
//        输入:"here"
//        输出:"here"
//        示例 3：
//
//        输入:"LOVELY"
//        输出:"lovely"


public class P709 {

    private static class Solution {
        public String toLowerCase(String str) {
            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    sb.append((char) (c - 'A' + 'a'));
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.toLowerCase("Hello"));
        System.out.println(solution.toLowerCase("here"));
        System.out.println(solution.toLowerCase("LOVELY"));
    }

}
