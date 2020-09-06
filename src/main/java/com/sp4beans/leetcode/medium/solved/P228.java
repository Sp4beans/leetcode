package com.sp4beans.leetcode.medium.solved;

//        给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
//
//        示例 1:
//
//        输入: [0,1,2,4,5,7]
//        输出: ["0->2","4->5","7"]
//        解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
//        示例 2:
//
//        输入: [0,2,3,4,6,8,9]
//        输出: ["0","2->4","6","8->9"]
//        解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。

import java.util.ArrayList;
import java.util.List;

public class P228 {
    private class Solution {
        public List<String> summaryRanges(int[] nums) {
            int curStart = 0;
            int curEnd = 0;
            List<String> ans = new ArrayList<>();
            if (nums.length == 0) {
                return ans;
            }
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    curStart = nums[i];
                    curEnd = nums[i];
                } else {
                    if (nums[i] == (curEnd + 1)) {
                        curEnd++;
                    } else {
                        if (curStart == curEnd) {
                            ans.add(String.valueOf(curStart));
                        } else {
                            ans.add(curStart + "->" + curEnd);
                        }
                        curStart = nums[i];
                        curEnd = nums[i];
                    }
                }
            }
            if (curStart == curEnd) {
                ans.add(String.valueOf(curStart));
            } else {
                ans.add(curStart + "->" + curEnd);
            }
            return ans;
        }
    }
}
