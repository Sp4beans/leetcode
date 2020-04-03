package com.sp4beans.leetcode.easy.solved;

//        对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
//
//        返回字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
//
//         
//
//        示例 1：
//
//        输入：str1 = "ABCABC", str2 = "ABC"
//        输出："ABC"
//        示例 2：
//
//        输入：str1 = "ABABAB", str2 = "ABAB"
//        输出："AB"
//        示例 3：
//
//        输入：str1 = "LEET", str2 = "CODE"
//        输出：""
//         
//
//        提示：
//
//        1 <= str1.length <= 1000
//        1 <= str2.length <= 1000
//        str1[i] 和 str2[i] 为大写英文字母

public class P1071 {
    private static class Solution {
        public String gcdOfStrings(String str1, String str2) {
            if (!(str1 + str2).equals(str2 + str1)) {
                return "";
            }
            return str1.substring(0, gcd(str1.length(), str2.length()));
        }

        public int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(solution.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(solution.gcdOfStrings("LEET", "CODE"));
    }
}
