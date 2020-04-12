package com.sp4beans.leetcode.medium.solved;

//        给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
//
//         
//
//        示例 1：
//
//        输入：matrix =
//        [
//          [0,1,1,1],
//          [1,1,1,1],
//          [0,1,1,1]
//        ]
//        输出：15
//        解释：
//        边长为 1 的正方形有 10 个。
//        边长为 2 的正方形有 4 个。
//        边长为 3 的正方形有 1 个。
//        正方形的总数 = 10 + 4 + 1 = 15.
//        示例 2：
//
//        输入：matrix =
//        [
//        [1,0,1],
//        [1,1,0],
//        [1,1,0]
//        ]
//        输出：7
//        解释：
//        边长为 1 的正方形有 6 个。
//        边长为 2 的正方形有 1 个。
//        正方形的总数 = 6 + 1 = 7.
//         
//
//        提示：
//
//        1 <= arr.length <= 300
//        1 <= arr[0].length <= 300
//        0 <= arr[i][j] <= 1

public class P1277 {

    private class Solution {
        public int countSquares(int[][] matrix) {

            int height = matrix.length;
            int length = matrix[0].length;

            int[][] x = new int[height][length];
            int[][] y = new int[height][length];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    if (matrix[i][j] == 1) {
                        x[i][j] = j == 0 ? 1 : x[i][j - 1] + 1;
                        y[i][j] = i == 0 ? 1 : y[i - 1][j] + 1;
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    if (matrix[i][j] == 1) {
                        int curLen = 1;
                        ans ++;
                        while (i + curLen < height && j + curLen < length) {
                            if (x[i + curLen][j + curLen] > curLen
                                    &&y[i + curLen][j + curLen] > curLen) {
                                ans ++;
                                curLen ++;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }

            return ans;
        }
    }

}
