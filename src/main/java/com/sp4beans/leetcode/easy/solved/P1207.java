package com.sp4beans.leetcode.easy.solved;

//        给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
//
//        如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
//
//         
//
//        示例 1：
//
//        输入：arr = [1,2,2,1,1,3]
//        输出：true
//        解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
//        示例 2：
//
//        输入：arr = [1,2]
//        输出：false
//        示例 3：
//
//        输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
//        输出：true
//         
//
//        提示：
//
//        1 <= arr.length <= 1000
//        -1000 <= arr[i] <= 1000

import java.util.HashMap;
import java.util.HashSet;

public class P1207 {

    private static class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            HashMap<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                int cur = arr[i];
                if (countMap.containsKey(cur)) {
                    countMap.put(cur, countMap.get(cur) + 1);
                } else {
                    countMap.put(cur, 1);
                }
            }
            HashSet<Integer> countSet = new HashSet<>();
            for (int count : countMap.values()) {
                if (countSet.contains(count)) {
                    return false;
                }
                countSet.add(count);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(solution.uniqueOccurrences(new int[]{1,2}));
        System.out.println(solution.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
}
