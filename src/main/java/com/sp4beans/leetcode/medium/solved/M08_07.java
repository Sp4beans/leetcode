package com.sp4beans.leetcode.medium.solved;

//        无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
//
//        示例1:
//
//        输入：S = "qwe"
//        输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
//        示例2:
//
//        输入：S = "ab"
//        输出：["ab", "ba"]
//        提示:
//
//        字符都是英文字母。
//        字符串长度在[1, 9]之间。

import java.util.ArrayList;
import java.util.List;

public class M08_07 {
    private class Solution {
        List<String> ans = new ArrayList<>();

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
}
