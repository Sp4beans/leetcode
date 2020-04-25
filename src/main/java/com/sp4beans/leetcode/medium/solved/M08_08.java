package com.sp4beans.leetcode.medium.solved;

//        有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
//
//        示例1:
//
//        输入：S = "qqe"
//        输出：["eqq","qeq","qqe"]
//        示例2:
//
//        输入：S = "ab"
//        输出：["ab", "ba"]
//        提示:
//
//        字符都是英文字母。
//        字符串长度在[1, 9]之间。

import java.util.HashSet;
import java.util.Set;

public class M08_08 {
    private static class Solution {
        Set<String> ans = new HashSet<>();

        public String[] permutation(String S) {
            boolean[] used = new boolean[S.length()];
            func("", S, used);
            String[] result = new String[ans.size()];
            return ans.toArray(result);
        }

        public void func(String cur, String s, boolean[] used) {
            if (cur.length() == s.length()) {
                ans.add(cur);
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                if (!used[i]) {
                    used[i] = true;
                    cur += s.charAt(i);
                    func(cur, s, used);
                    cur = cur.substring(0, cur.length() - 1);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permutation("qqe");

    }
}
