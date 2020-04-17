package com.sp4beans.leetcode.medium.solved;

//        编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
//
//         
//
//        示例 1：
//
//        输入：
//        [
//        [1,1,1],
//        [1,0,1],
//        [1,1,1]
//        ]
//        输出：
//        [
//        [1,0,1],
//        [0,0,0],
//        [1,0,1]
//        ]
//        示例 2：
//
//        输入：
//        [
//        [0,1,2,0],
//        [3,4,5,2],
//        [1,3,1,5]
//        ]
//        输出：
//        [
//        [0,0,0,0],
//        [0,4,5,0],
//        [0,3,1,0]
//        ]

public class M01_08 {
    private class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }
            boolean[] row = new boolean[matrix.length];
            boolean[] col = new boolean[matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = true;
                        col[j] = true;
                    }
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (row[i] || col[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
