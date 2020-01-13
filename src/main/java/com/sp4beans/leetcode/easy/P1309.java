package com.sp4beans.leetcode.easy;

//        给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
//
//        字符（'a' - 'i'）分别用（'1' - '9'）表示。
//        字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
//        返回映射之后形成的新字符串。
//
//        题目数据保证映射始终唯一。
//
//         
//
//        示例 1：
//
//        输入：s = "10#11#12"
//        输出："jkab"
//        解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
//        示例 2：
//
//        输入：s = "1326#"
//        输出："acz"
//        示例 3：
//
//        输入：s = "25#"
//        输出："y"
//        示例 4：
//
//        输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
//        输出："abcdefghijklmnopqrstuvwxyz"
//         
//
//        提示：
//
//        1 <= s.length <= 1000
//        s[i] 只包含数字（'0'-'9'）和 '#' 字符。
//        s 是映射始终存在的有效字符串。

public class P1309 {

    private static class Solution {
        public String freqAlphabets(String s) {
            StringBuffer result = new StringBuffer();
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (i + 2 < cs.length && cs[i+2] == '#') {
                    int t = (cs[i] - '0') * 10 + (cs[i+1] - '0');
                    result.append((char) (t + 'a' - 1));
                    i += 2;
                } else {
                    int t = cs[i] - '0';
                    result.append((char) (t + 'a' - 1));
                }
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.freqAlphabets("10#11#12"));
        System.out.println(solution.freqAlphabets("1326#"));
        System.out.println(solution.freqAlphabets("25#"));
        System.out.println(solution.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }

}
