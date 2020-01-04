package com.sp4beans.leetcode.easy;

//        给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
//
//        (注：分数越高的选手，排名越靠前。)
//
//        示例 1:
//
//        输入: [5, 4, 3, 2, 1]
//        输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
//        解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
//        余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
//        提示:
//
//        N 是一个正整数并且不会超过 10000。
//        所有运动员的成绩都不相同。

import java.util.Arrays;
import java.util.HashMap;

public class P506 {
    private class Solution {
        public String[] findRelativeRanks(int[] nums) {
            int[] ranks = Arrays.copyOf(nums, nums.length);
            Arrays.sort(ranks);
            HashMap<Integer, String> score2rank = new HashMap<>();
            for (int i = 0; i < ranks.length; i++) {
                score2rank.put(ranks[i], String.valueOf(ranks.length - i));
            }
            String[] result = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                String target = score2rank.get(nums[i]);
                switch (target) {
                    case "1":
                        target = "Gold Medal";
                        break;
                    case "2":
                        target = "Silver Medal";
                        break;
                    case "3":
                        target = "Bronze Medal";
                        break;
                    default:
                        break;
                }
                result[i] = target;
            }
            return result;
        }
    }
}
