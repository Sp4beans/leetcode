package com.sp4beans.leetcode.easy;

//        给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。
//
//         
//
//        示例 1：
//
//        输入："leetcodeisacommunityforcoders"
//        输出："ltcdscmmntyfrcdrs"
//        示例 2：
//
//        输入："aeiou"
//        输出：""
//         
//
//        提示：
//
//        S 仅由小写英文字母组成。
//        1 <= S.length <= 1000

public class P1119 {

    private static class Solution {
        public String removeVowels(String S) {
            StringBuilder sb = new StringBuilder();

            for (char c : S.toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') continue;
                sb.append(c);
            }

            return sb.toString();
        }
    }


    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.removeVowels("leetcodeisacommunityforcoders"));
        System.out.println(solution.removeVowels("aeiou"));
    }
}
