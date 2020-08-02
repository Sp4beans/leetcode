package com.sp4beans.leetcode.medium.solved;

//        给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//        说明：解集不能包含重复的子集。
//
//        示例:
//
//        输入: [1,2,2]
//        输出:
//        [
//        [2],
//        [1],
//        [1,2,2],
//        [2,2],
//        [1,2],
//        []
//        ]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90 {

    private class Solution {
        List<List<Integer>> result;

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            result = new ArrayList<>();
            Arrays.sort(nums);
            helper(nums, 0, new ArrayList<>());
            return result;
        }

        private void helper(int[] nums, int start, List<Integer> temp) {
            result.add(new ArrayList<>(temp));
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                temp.add(nums[i]);
                helper(nums, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
