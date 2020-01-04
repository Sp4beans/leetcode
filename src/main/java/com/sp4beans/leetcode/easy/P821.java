package com.sp4beans.leetcode.easy;

//        给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
//
//        示例 1:
//
//        输入: S = "loveleetcode", C = 'e'
//        输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
//        说明:
//
//        字符串 S 的长度范围为 [1, 10000]。
//        C 是一个单字符，且保证是字符串 S 里的字符。
//        S 和 C 中的所有字母均为小写字母。

public class P821 {
    private class Solution {
        public int[] shortestToChar(String S, char C) {
            int[] result = new int[S.length()];
            int left = -1;
            int right = -1;
            for (int i = 0; i < S.length(); i++) {
                if (i > right) {
                    for (int j = i; j < result.length; j++) {
                        if (S.charAt(j) == C) {
                            left = right;
                            right = j;
                            break;
                        }
                    }
                }
                if (left == -1) {
                    result[i] = Math.abs(right - i);
                } else {
                    result[i] = Math.abs(Integer.min(right - i, i - left));
                }

            }
            return result;
        }
    }
}