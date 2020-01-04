package com.sp4beans.leetcode.easy;

//        包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
//
//        示例 1:
//
//        输入:
//        [[1,1,1],
//        [1,0,1],
//        [1,1,1]]
//        输出:
//        [[0, 0, 0],
//        [0, 0, 0],
//        [0, 0, 0]]
//        解释:
//        对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
//        对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
//        对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
//        注意:
//
//        给定矩阵中的整数范围为 [0, 255]。
//        矩阵的长和宽的范围均为 [1, 150]。

public class P661 {

    private class Solution {
        public int[][] imageSmoother(int[][] M) {
            int[] x = new int[]{0, 1, 0, -1, -1, 1, -1, 1};
            int[] y = new int[]{1, 0, -1, 0, -1, -1, 1, 1};

            int row = M.length;
            int col = M[0].length;

            int[][] result = new int[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int count = 1;
                    int sum = M[i][j];
                    for (int k = 0; k < 8; k++) {
                        int newI = i + x[k];
                        int newJ = j + y[k];
                        if (newI >= 0 && newI < row && newJ >= 0 && newJ < col) {
                            count++;
                            sum += M[newI][newJ];
                        }
                    }
                    result[i][j] = sum / count;
                }
            }
            return result;
        }
    }
}
