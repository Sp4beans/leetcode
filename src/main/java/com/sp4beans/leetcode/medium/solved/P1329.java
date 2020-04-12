package com.sp4beans.leetcode.medium.solved;

//        给你一个 m * n 的整数矩阵 mat ，请你将同一条对角线上的元素（从左上到右下）按升序排序后，返回排好序的矩阵。
//
//         
//
//        示例 1：
//
//
//
//        输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
//        输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
//         
//
//        提示：
//
//        m == mat.length
//        n == mat[i].length
//        1 <= m, n <= 100
//        1 <= mat[i][j] <= 100

public class P1329 {
    private class Solution {
        public int[][] diagonalSort(int[][] mat) {
            int height = mat.length;
            int length = mat[0].length;

            int min = -height + 1;
            int max = length;
            for (int sum = min; sum < max; sum++) {
                for (int i = 0; i < height; i++) {
                    if (sum + i < 0 || sum + i >= length) {
                        continue;
                    }
                    for (int j = i + 1; j < height; j++) {
                        if (sum + j < 0 || sum + j >= length) {
                            continue;
                        }
                        if (mat[i][sum+i] > mat[j][sum+j]) {
                            int tmp = mat[i][sum+i];
                            mat[i][sum+i] = mat[j][sum+j];
                            mat[j][sum+j] = tmp;
                        }
                    }
                }
            }

            return mat;
        }
    }
}
