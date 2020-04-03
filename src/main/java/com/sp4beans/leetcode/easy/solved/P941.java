package com.sp4beans.leetcode.easy.solved;

//        给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
//
//        让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
//
//        A.length >= 3
//        在 0 < i < A.length - 1 条件下，存在 i 使得：
//        A[0] < A[1] < ... A[i-1] < A[i]
//        A[i] > A[i+1] > ... > A[B.length - 1]
//         
//
//        示例 1：
//
//        输入：[2,1]
//        输出：false
//        示例 2：
//
//        输入：[3,5,5]
//        输出：false
//        示例 3：
//
//        输入：[0,3,2,1]
//        输出：true
//         
//
//        提示：
//
//        0 <= A.length <= 10000
//        0 <= A[i] <= 10000 

public class P941 {
    private static class Solution {
        public boolean validMountainArray(int[] A) {
            if (A.length <= 2) {
                return false;
            }
            boolean inc = true;
            int incCount = 0;
            int desCount = 0;
            for (int i = 0; i < A.length - 1; i++) {
                if (inc) {
                    if (A[i + 1] < A[i]) {
                        if (incCount == 0) {
                            return false;
                        } else {
                            desCount++;
                            inc = false;
                        }
                    } else if (A[i + 1] == A[i]) {
                        return false;
                    } else {
                        incCount++;
                    }
                } else {
                    if (A[i + 1] >= A[i]) {
                        return false;
                    }
                }
            }
            return !inc;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.validMountainArray(new int[]{2, 1}));
        System.out.println(solution.validMountainArray(new int[]{3, 5, 5}));
        System.out.println(solution.validMountainArray(new int[]{0, 3, 2, 1}));
        System.out.println(solution.validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

}
