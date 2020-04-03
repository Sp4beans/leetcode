package com.sp4beans.leetcode.easy.solved;

//        给定两个数组，编写一个函数来计算它们的交集。
//
//        示例 1:
//
//        输入: nums1 = [1,2,2,1], nums2 = [2,2]
//        输出: [2]
//        示例 2:
//
//        输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//        输出: [9,4]
//        说明:
//
//        输出结果中的每个元素一定是唯一的。
//        我们可以不考虑输出结果的顺序。

import java.util.HashSet;

public class P349 {
    private class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int num : nums1) {
                set.add(num);
            }
            HashSet<Integer> result = new HashSet<>();
            for (int num : nums2) {
                if (set.contains(num)) {
                    result.add(num);
                }
            }
            int[] res = new int[result.size()];
            int i = 0;
            for (Integer num : result) {
                res[i++] = num;
            }
            return res;
        }
    }
}
