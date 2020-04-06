package com.sp4beans.leetcode.easy.solved;

//        给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
//
//        初始化 A 和 B 的元素数量分别为 m 和 n。
//
//        示例:
//
//        输入:
//        A = [1,2,3,0,0,0], m = 3
//        B = [2,5,6],       n = 3
//
//        输出: [1,2,2,3,5,6]
//        说明:
//
//        A.length == n + m

import java.util.Arrays;

public class M10_01 {
    private class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int[] C = Arrays.copyOf(A, m);
            int index = 0;
            int indexB = 0;
            int indexC = 0;
            while (index < m + n) {
                if (indexB >= n) {
                    A[index++] = C[indexC++];
                } else if (indexC >= m) {
                    A[index++] = B[indexB++];
                } else {
                    int b = B[indexB];
                    int c = C[indexC];
                    if (b > c) {
                        A[index++] = C[indexC++];
                    } else {
                        A[index++] = B[indexB++];
                    }
                }
            }
        }
    }
}
