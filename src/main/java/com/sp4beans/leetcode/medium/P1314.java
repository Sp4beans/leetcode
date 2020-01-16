package com.sp4beans.leetcode.medium;

//        给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 
//
//        i - K <= r <= i + K, j - K <= c <= j + K 
//        (r, c) 在矩阵内。
//         
//
//        示例 1：
//
//        输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
//        输出：[[12,21,16],[27,45,33],[24,39,28]]
//        示例 2：
//
//        输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
//        输出：[[45,45,45],[45,45,45],[45,45,45]]
//         
//
//        提示：
//
//        m == mat.length
//        n == mat[i].length
//        1 <= m, n, K <= 100
//        1 <= mat[i][j] <= 100

public class P1314 {
    private class Solution {
        public int[][] matrixBlockSum(int[][] mat, int K) {
            int ii = mat.length;
            int jj = mat[0].length;

            int[][] result = new int[ii][jj];

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    for (int ni = i - K; ni <= i + K; ni++) {
                        if (ni < 0 || ni >= ii) {
                            continue;
                        }
                        for (int nj = j - K; nj <= j + K; nj++) {
                            if (nj < 0 || nj >= jj) {
                                continue;
                            }
                            result[ni][nj] += mat[i][j];
                        }
                    }
                }
            }

            return result;
        }
    }
}
