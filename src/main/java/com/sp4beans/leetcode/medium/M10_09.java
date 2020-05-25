package com.sp4beans.leetcode.medium;

//        给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
//
//        示例:
//
//        现有矩阵 matrix 如下：
//
//        [
//        [1,   4,  7, 11, 15],
//        [2,   5,  8, 12, 19],
//        [3,   6,  9, 16, 22],
//        [10, 13, 14, 17, 24],
//        [18, 21, 23, 26, 30]
//        ]
//        给定 target = 5，返回 true。
//
//        给定 target = 20，返回 false。

public class M10_09 {
    private class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // start our "pointer" in the bottom-left
            int row = matrix.length-1;
            int col = 0;

            while (row >= 0 && col < matrix[0].length) {
                if (matrix[row][col] > target) {
                    row--;
                } else if (matrix[row][col] < target) {
                    col++;
                } else { // found it
                    return true;
                }
            }

            return false;
        }
    }
}
