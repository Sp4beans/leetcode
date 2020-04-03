package com.sp4beans.leetcode.easy.solved;

//        给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
//
//        如果不存在最后一个单词，请返回 0 。
//
//        说明：一个单词是指由字母组成，但不包含任何空格的字符串。
//
//        示例:
//
//        输入:"Hello World"
//        输出:5

public class P58 {
    private static class Solution {
        public int lengthOfLastWord(String s) {
            int length = 0;
            boolean started = false;
            char[] chars = s.toCharArray();
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = chars[i];
                if (!started) {
                    if (c == ' ') {
                        continue;
                    } else {
                        started = true;
                        length++;
                    }
                } else {
                    if (c == ' ') {
                        break;
                    } else {
                        length++;
                    }
                }
            }
            return length;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("Hello World"));
    }
}
