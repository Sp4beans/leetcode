package com.sp4beans.leetcode.medium.solved;

import java.util.HashSet;
import java.util.Set;

//        输入一个字符串，打印出该字符串中字符的所有排列。
//
//         
//
//        你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
//         
//
//        示例:
//
//        输入：s = "abc"
//        输出：["abc","acb","bac","bca","cab","cba"]
//         
//
//        限制：
//
//        1 <= s 的长度 <= 8

public class M38 {
    private class Solution {
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
}
