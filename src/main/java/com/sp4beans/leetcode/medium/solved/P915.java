package com.sp4beans.leetcode.medium.solved;

//        给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
//
//        left 中的每个元素都小于或等于 right 中的每个元素。
//        left 和 right 都是非空的。
//        left 要尽可能小。
//        在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
//
//         
//
//        示例 1：
//
//        输入：[5,0,3,8,6]
//        输出：3
//        解释：left = [5,0,3]，right = [8,6]
//        示例 2：
//
//        输入：[1,1,1,0,6,12]
//        输出：4
//        解释：left = [1,1,1,0]，right = [6,12]
//         
//
//        提示：
//
//        2 <= A.length <= 30000
//        0 <= A[i] <= 10^6
//        可以保证至少有一种方法能够按题目所描述的那样对 A 进行划分。

public class P915 {
    private class Solution {
        public int partitionDisjoint(int[] A) {
            int[] max = new int[A.length]; // 左边最大值
            int[] min = new int[A.length]; // 右边最小值
            for (int i = 0; i < A.length; i++) {
                if (i == 0) {
                    max[i] = A[i];
                } else {
                    max[i] = Math.max(max[i - 1], A[i]);
                }
            }
            for (int i = A.length - 1; i >= 0; i--) {
                if (i == A.length - 1) {
                    min[i] = A[i];
                } else {
                    min[i] = Math.min(min[i + 1], A[i]);
                }
            }
            for(int i = 0; i < A.length - 1; i++) {
                if (max[i] <= min[i + 1]) {
                    return i + 1;
                }
            }
            return 0;
        }
    }
}
