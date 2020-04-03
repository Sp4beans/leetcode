package com.sp4beans.leetcode.easy.solved;

//        给定两个字符串 s 和 t，它们只包含小写字母。
//
//        字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
//        请找出在 t 中被添加的字母。
//
//         
//
//        示例:
//
//        输入：
//        s = "abcd"
//        t = "abcde"
//
//        输出：
//        e
//
//        解释：
//        'e' 是那个被添加的字母。

public class P389 {
    private static class Solution {
        public char findTheDifference(String s, String t) {
            int ans = 0;
            for (char c : s.toCharArray()) {
                ans ^= c;
            }
            for (char c : t.toCharArray()) {
                ans ^= c;
            }
            return (char) ans;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.findTheDifference("abcd", "abcde"));
    }

}
