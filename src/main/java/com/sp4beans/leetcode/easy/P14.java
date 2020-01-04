package com.sp4beans.leetcode.easy;

//        编写一个函数来查找字符串数组中的最长公共前缀。
//
//        如果不存在公共前缀，返回空字符串 ""。
//
//        示例 1:
//
//        输入: ["flower","flow","flight"]
//        输出: "fl"
//        示例 2:
//
//        输入: ["dog","racecar","car"]
//        输出: ""
//        解释: 输入不存在公共前缀。
//        说明:
//
//        所有输入只包含小写字母 a-z 。

public class P14 {

    private static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            } else if (strs.length == 1) {
                return strs[0];
            } else {
                String ans = strs[0];
                for (int i = 1; i < strs.length; i++) {
                    ans = lcs(ans, strs[i]);
                    if (ans.length() == 0) {
                        return ans;
                    }
                }
                return ans;
            }
        }

        public String lcs(String a, String b) {
            if (a.length() == 0 || b.length() == 0) {
                return "";
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < Integer.min(a.length(), b.length()); i++) {
                if (a.charAt(i) == b.charAt(i)) {
                    ans.append(a.charAt(i));
                } else {
                    break;
                }
            }
            return ans.toString();
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
