package com.sp4beans.leetcode.medium.solved;

//        给定一个没有重复数字的序列，返回其所有可能的全排列。
//
//        示例:
//
//        输入: [1,2,3]
//        输出:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]

import java.util.ArrayList;
import java.util.List;

public class P46 {

    private class Solution {

        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            boolean[] used = new boolean[nums.length];
            func(new ArrayList<>(), nums, used);
            return ans;
        }

        public void func(List<Integer> list, int[] nums, boolean[] used) {
            if (list.size() == nums.length) {
                List<Integer> ansItem = new ArrayList<>();
                ansItem.addAll(list);
                ans.add(ansItem);
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    list.add(nums[i]);
                    func(list, nums, used);
                    list.remove(list.size() - 1);
                    used[i] = false;
                }
            }
        }


    }
}
