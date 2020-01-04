package com.sp4beans.leetcode.easy;

//        给定一个单词，你需要判断单词的大写使用是否正确。
//
//        我们定义，在以下情况时，单词的大写用法是正确的：
//
//        全部字母都是大写，比如"USA"。
//        单词中所有字母都不是大写，比如"leetcode"。
//        如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
//        否则，我们定义这个单词没有正确使用大写字母。
//
//        示例 1:
//
//        输入: "USA"
//        输出: True
//        示例 2:
//
//        输入: "FlaG"
//        输出: False
//        注意: 输入是由大写和小写拉丁字母组成的非空单词。

public class P520 {
    private static class Solution {
        public boolean detectCapitalUse(String word) {
            boolean startWithUpper = false;
            boolean allUpper = false;
            boolean allLower = false;
            for (int i = 0; i < word.length(); i++) {
                if (i == 0) {
                    startWithUpper = Character.isUpperCase(word.charAt(i));
                } else if (i == 1) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        if (startWithUpper) {
                            allUpper = true;
                        } else {
                            return false;
                        }
                    } else {
                        allLower = true;
                    }
                } else {
                    if (Character.isUpperCase(word.charAt(i)) && allLower) {
                        return false;
                    } else if (Character.isLowerCase(word.charAt(i)) && allUpper) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.detectCapitalUse("USA"));
        System.out.println(solution.detectCapitalUse("FlaG"));
    }
}
