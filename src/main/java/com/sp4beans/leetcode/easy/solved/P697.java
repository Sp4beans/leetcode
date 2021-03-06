package com.sp4beans.leetcode.easy.solved;

//        给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
//
//        你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
//
//        示例 1:
//
//        输入: [1, 2, 2, 3, 1]
//        输出: 2
//        解释:
//        输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//        连续子数组里面拥有相同度的有如下所示:
//        [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//        最短连续子数组[2, 2]的长度为2，所以返回2.
//        示例 2:
//
//        输入: [1,2,2,3,1,4,2]
//        输出: 6
//        注意:
//
//        nums.length 在1到50,000区间范围内。
//        nums[i] 是一个在0到49,999范围内的整数。

import java.util.HashMap;
import java.util.Map;

public class P697 {
    private static class Solution {

        class Node {
            int count;
            int startIndex;
            int endIndex;

            Node(int count, int startIndex, int endIndex) {
                this.count = count;
                this.startIndex = startIndex;
                this.endIndex = endIndex;
            }
        }

        public int findShortestSubArray(int[] nums) {
            int maxCount = 0;
            Map<Integer, Node> map = new HashMap<>();
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int count = 1;
                int startIndex = i;
                int endIndex = i;
                if (map.containsKey(num)) {
                    Node node = map.get(num);
                    count += node.count;
                    startIndex = node.startIndex;
                }
                map.put(num, new Node(count, startIndex, endIndex));
                if (count > maxCount) {
                    maxCount = count;
                    result = endIndex - startIndex + 1;
                } else if (count == maxCount) {
                    result = Integer.min(result, endIndex - startIndex + 1);
                }
            }
            return result;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }
}
