package com.sp4beans.leetcode.easy;

//        给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
//
//        示例:
//
//        输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//        输出: [3,3,5,5,6,7]
//        解释:
//
//        滑动窗口的位置                最大值
//        ---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7
//         
//
//        提示：
//
//        你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

import java.util.LinkedList;

public class M59I {
    private class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length < 1 && k < 1) {
                return new int[0];
            }

            int index = 0;
            int[] result = new int[nums.length - k + 1];
            LinkedList<Integer> queue = new LinkedList<>();

            for (int i = 0; i < nums.length; i++) {

                while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }

                queue.addLast(i);

                if (queue.peekFirst() == (i - k)) {
                    queue.pollFirst();
                }

                if (i >= (k - 1)) {
                    result[index++] = nums[queue.peekFirst()];
                }
            }

            return result;
        }
    }
}
