package com.sp4beans.leetcode.medium;

//        找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
//        说明：
//
//        所有数字都是正整数。
//        解集不能包含重复的组合。 
//        示例 1:
//
//        输入: k = 3, n = 7
//        输出: [[1,2,4]]
//        示例 2:
//
//        输入: k = 3, n = 9
//        输出: [[1,2,6], [1,3,5], [2,3,4]]

import java.util.ArrayList;
import java.util.List;

public class P216 {
    private static class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            backtrack(new ArrayList<>(), 0, k, n);
            return ans;
        }

        public void backtrack(List<Integer> cur, int start, int k, int n) {
            if (0 == n && cur.size() == k) {
                ans.add(new ArrayList<>(cur));
                return;
            }

            if (cur.size() > k || n < 0) {
                return;
            }

            for (int i = 1; i <= 9; i++) {
                if (i <= start) continue;
                cur.add(i);
                backtrack(cur, i, k, n - i);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum3(3, 7));
    }

}
