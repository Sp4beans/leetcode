package com.sp4beans.leetcode.medium;

//        给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
//
//        找到所有出现两次的元素。
//
//        你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
//
//        示例：
//
//        输入:
//        [4,3,2,7,8,2,3,1]
//        [1,2,3,4,5,6,7,8]
//
//        输出:
//        [2,3]

import java.util.ArrayList;
import java.util.List;

public class P442 {
    private class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int base = Math.abs(nums[i]);
                int target = nums[base - 1];
                if (target < 0) {
                    ans.add(base);
                } else {
                    nums[base - 1] = -target;
                }
            }
            return ans;
        }
    }
}
