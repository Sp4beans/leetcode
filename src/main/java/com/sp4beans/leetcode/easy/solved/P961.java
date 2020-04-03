package com.sp4beans.leetcode.easy.solved;

//        在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
//
//        返回重复了 N 次的那个元素。
//
//         
//
//        示例 1：
//
//        输入：[1,2,3,3]
//        输出：3
//        示例 2：
//
//        输入：[2,1,2,5,3,2]
//        输出：2
//        示例 3：
//
//        输入：[5,1,5,2,5,3,5,4]
//        输出：5
//         
//
//        提示：
//
//        4 <= A.length <= 10000
//        0 <= A[i] < 10000
//        A.length 为偶数

import java.util.HashSet;
import java.util.Set;

public class P961 {
    private static class Solution {
        public int repeatedNTimes(int[] A) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < A.length; i++) {
                if (!set.contains(A[i])) {
                    set.add(A[i]);
                } else {
                    return A[i];
                }
            }
            return 0;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(solution.repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(solution.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }
}
