package com.sp4beans.leetcode.easy;

//        输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//
//
//        示例 1：
//
//        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//        输出：[1,2,3,6,9,8,7,4,5]
//        示例 2：
//
//        输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//        输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//        限制：
//
//        0 <= matrix.length <= 100
//        0 <= matrix[i].length <= 100
public class M29 {
    private class Solution {
        public int[] spiralOrder(int[][] matrix) {

            int m = matrix.length;
            if (m <= 0) {
                return new int[]{};
            }
            int n = matrix[0].length;

            int minX = 0;
            int maxX = m - 1;
            int minY = 0;
            int maxY = n - 1;

            int[] result = new int[m * n];
            int index = 0;
            while (minX <= maxX && minY <= maxY) {
                for(int i = minY; i <= maxY; i++) {
                    result[index++] = matrix[minX][i];
                }
                minX++;

                for(int i = minX; i <= maxX; i++) {
                    result[index++] = matrix[i][maxY];
                }
                maxY--;

                if (minX > maxX || minY > maxY) {
                    break;
                }

                for(int i = maxY; i >= minY; i--) {
                    result[index++] = matrix[maxX][i];
                }
                maxX--;

                for(int i = maxX; i >= minX; i--) {
                    result[index++] = matrix[i][minY];
                }
                minY++;
            }

            return result;
        }

    }
}

