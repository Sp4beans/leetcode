package com.sp4beans.leetcode.easy;

//        和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
//
//        现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
//
//        示例 1:
//
//        输入: [1,3,2,2,5,2,3,7]
//        输出: 5
//        原因: 最长的和谐数组是：[3,2,2,2,3].
//        说明: 输入的数组长度最大不超过20,000.

import java.util.Arrays;

public class P594 {
    private static class Solution {
        public int findLHS(int[] nums) {
            Arrays.sort(nums);
            int begin = 0, res = 0;
            for (int end = 0; end < nums.length; end++) {
                while (nums[end] - nums[begin] > 1) {
                    begin++;
                }
                if (nums[end] - nums[begin] == 1)
                    res = Math.max(res, end - begin + 1);
            }
            return res;
//            Map<Integer, Integer> map = new HashMap<>();
//            int ans = 0;
//            for (int num : nums) {
//                if (map.containsKey(num)) {
//                    map.put(num, map.get(num) + 1);
//                } else {
//                    map.put(num, 1);
//                }
//
//                if (map.containsKey(num - 1)) {
//                    ans = Integer.max(ans, map.get(num) + map.get(num - 1));
//                }
//                if (map.containsKey(num + 1)) {
//                    ans = Integer.max(ans, map.get(num) + map.get(num + 1));
//                }
//
//            }
//            return ans;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }
}
