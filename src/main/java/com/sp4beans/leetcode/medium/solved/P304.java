package com.sp4beans.leetcode.medium.solved;

//        给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
//
//
//        上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
//
//        示例:
//
//        给定 matrix = [
//        [3, 0, 1, 4, 2],
//        [5, 6, 3, 2, 1],
//        [1, 2, 0, 1, 5],
//        [4, 1, 0, 1, 7],
//        [1, 0, 3, 0, 5]
//        ]
//
//        sumRegion(2, 1, 4, 3) -> 8
//        sumRegion(1, 1, 2, 2) -> 11
//        sumRegion(1, 2, 2, 4) -> 12
//        说明:
//
//        你可以假设矩阵不可变。
//        会多次调用 sumRegion 方法。
//        你可以假设 row1 ≤ row2 且 col1 ≤ col2。

public class P304 {
    private class NumMatrix {

        int[][] matrix;
        int[][] sum;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            init();
        }

        private void init() {
            int length = matrix.length;
            int height = matrix[0].length;
            sum = new int[length][height];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < height; j++) {
                    if (j > 0) {
                        sum[i][j] = matrix[i][j] + sum[i][j - 1];
                    } else {
                        sum[i][j] = matrix[i][j];
                    }
                }
            }

            for (int j = 0; j < height; j++) {
                for (int i = 0; i < length; i++) {
                    if (i > 0) {
                        sum[i][j] += sum[i - 1][j];
                    }
                }
            }

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < height; j++) {
                    System.out.print(sum[i][j] + " ");
                }
                System.out.println();
            }
        }

        private int sumRegion(int row, int col) {
            if (row < 0 || col < 0) {
                return 0;
            }
            return sum[row][col];
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sumRegion(row2, col2) + sumRegion(row1 - 1, col1 - 1) - sumRegion(row1 - 1, col2) - sumRegion(row1,
                    col2 - 1);
        }
    }

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
}
