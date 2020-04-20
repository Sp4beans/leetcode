package com.sp4beans.leetcode.medium;

//        括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
//
//        说明：解集不能包含重复的子集。
//
//        例如，给出 n = 3，生成结果为：
//
//        [
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"
//        ]

import java.util.ArrayList;
import java.util.List;

public class M08_09 {
    private class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            backtrack(ans, "", 0, 0, n);
            return ans;
        }

        public void backtrack(List<String> ans, String cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                ans.add(cur);
                return;
            }
            if (open < max) {
                backtrack(ans, cur + "(", open + 1, close, max);
            }
            if (close < open) {
                backtrack(ans, cur + ")", open, close + 1, max);
            }
        }
    }
}
