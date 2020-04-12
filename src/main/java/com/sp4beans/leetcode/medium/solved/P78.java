package com.sp4beans.leetcode.medium.solved;

//        给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//        说明：解集不能包含重复的子集。
//
//        示例:
//
//        输入: nums = [1,2,3]
//        输出:
//        [
//        [3],
//          [1],
//          [2],
//          [1,2,3],
//          [1,3],
//          [2,3],
//          [1,2],
//          []
//        ]

import java.util.ArrayList;
import java.util.List;

public class P78 {
    private class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < (1 << nums.length); i++) {
                List<Integer> item = new ArrayList<>();
                for (int j = 0; j < nums.length; j++) {
                    if (((i >> j) & 1) == 1) {
                        item.add(nums[j]);
                    }
                }
                ans.add(item);
            }
            return ans;
        }
    }

}
