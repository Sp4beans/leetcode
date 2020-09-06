package com.sp4beans.leetcode.medium;

//        在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//        示例 1:
//
//        输入: [3,2,1,5,6,4] 和 k = 2
//        输出: 5
//        示例 2:
//
//        输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//        输出: 4
//        说明:
//
//        你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

import java.util.PriorityQueue;

public class P215 {
    private static class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            for (int num : nums) {
                if (priorityQueue.size() < k) {
                    priorityQueue.add(num);
                } else {
                    priorityQueue.add(num);
                    priorityQueue.remove();
                }
            }
            return priorityQueue.remove();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution.findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
