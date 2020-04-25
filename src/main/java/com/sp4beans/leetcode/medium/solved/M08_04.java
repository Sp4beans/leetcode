package com.sp4beans.leetcode.medium.solved;

import java.util.ArrayList;
import java.util.List;

//        幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
//
//        说明：解集不能包含重复的子集。
//
//        示例:
//
//        输入： nums=[1,2,3]
//        输出：
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

public class M08_04 {

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
