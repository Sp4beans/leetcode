package com.sp4beans.leetcode.easy.solved;

//        给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
//
//         
//
//        示例 1：
//
//        输入："ab-cd"
//        输出："dc-ba"
//        示例 2：
//
//        输入："a-bC-dEf-ghIj"
//        输出："j-Ih-gfE-dCba"
//        示例 3：
//
//        输入："Test1ng-Leet=code-Q!"
//        输出："Qedo1ct-eeLg=ntse-T!"
//         
//
//        提示：
//
//        S.length <= 100
//        33 <= S[i].ASCIIcode <= 122 
//        S 中不包含 \ or "

public class P917 {
    private static class Solution {
        public String reverseOnlyLetters(String S) {
            int start = 0;
            int end = S.length() - 1;
            char[] s = S.toCharArray();
            while (end > start) {
                char startChar = s[start];
                char endChar = s[end];

                if (Character.isLetter(startChar) && Character.isLetter(endChar)) {
                    s[start] = s[end];
                    s[end] = startChar;
                    start++;
                    end--;
                }
                if (!Character.isLetter(startChar)) {
                    start++;
                }
                if (!Character.isLetter(endChar)) {
                    end--;
                }
            }
            return new String(s);
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.reverseOnlyLetters("ab-cd"));
        System.out.println(solution.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(solution.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
