package com.sp4beans.leetcode.medium.solved;

//        给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的数字可以无限制重复被选取。
//
//        说明：
//
//        所有数字（包括 target）都是正整数。
//        解集不能包含重复的组合。 
//        示例 1:
//
//        输入: candidates = [2,3,6,7], target = 7,
//        所求解集为:
//        [
//        [7],
//        [2,2,3]
//        ]
//        示例 2:
//
//        输入: candidates = [2,3,5], target = 8,
//        所求解集为:
//        [
//          [2,2,2,2],
//          [2,3,3],
//          [3,5]
//        ]

import java.util.ArrayList;
import java.util.List;

public class P39 {
    private class Solution {

        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backtrack(new ArrayList<>(), candidates, 0, target);
            return ans;
        }

        public void backtrack(List<Integer> cur, int[] candis, int start, int target) {

            if (target == 0) {
                ans.add(new ArrayList<>(cur));
            }
            if (target < 0) {
                return;
            }

            for (int i = start; i < candis.length; i++) {
                cur.add(candis[i]);
                backtrack(cur, candis, i, target - candis[i]);
                cur.remove(cur.size() - 1);
            }
        }

    }
}
