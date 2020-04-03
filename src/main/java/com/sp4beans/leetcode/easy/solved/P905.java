package com.sp4beans.leetcode.easy.solved;

//        给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
//
//        你可以返回满足此条件的任何数组作为答案。
//
//         
//
//        示例：
//
//        输入：[3,1,2,4]
//        输出：[2,4,3,1]
//        输出[4,2,3,1]，[2,4,1,3]和[4,2,1,3]也会被接受。
//         
//
//        提示：
//
//        1<=A.length<=5000
//        0<=A[i]<=5000


public class P905 {
    private class Solution {
        public int[] sortArrayByParity(int[] A) {
            int start = 0;
            int end = A.length - 1;
            while (end > start) {
                if (A[end] % 2 == 1) {
                    end--;
                } else if (A[start] % 2 == 0) {
                    start++;
                } else {
                    int tmp = A[end];
                    A[end] = A[start];
                    A[start] = tmp;
                    end--;
                    start++;
                }
            }
            return A;
        }
    }

}
