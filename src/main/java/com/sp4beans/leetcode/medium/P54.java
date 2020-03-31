package com.sp4beans.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

//        给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//
//        示例 1:
//
//        输入:
//        [
//        [ 1, 2, 3 ],
//        [ 4, 5, 6 ],
//        [ 7, 8, 9 ]
//        ]
//        输出: [1,2,3,6,9,8,7,4,5]
//        示例 2:
//
//        输入:
//        [
//        [1, 2, 3, 4],
//        [5, 6, 7, 8],
//        [9,10,11,12]
//        ]
//        输出: [1,2,3,4,8,12,11,10,9,5,6,7]
public class P54 {

    private class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            if (m <= 0) {
                return new ArrayList<>();
            }
            int n = matrix[0].length;

            int minX = 0;
            int maxX = m - 1;
            int minY = 0;
            int maxY = n - 1;

            List<Integer> result = new ArrayList<>();
            while (minX <= maxX && minY <= maxY) {
                for(int i = minY; i <= maxY; i++) {
                    result.add(matrix[minX][i]);
                }
                minX++;

                for(int i = minX; i <= maxX; i++) {
                    result.add(matrix[i][maxY]);
                }
                maxY--;

                if (minX > maxX || minY > maxY) {
                    break;
                }

                for(int i = maxY; i >= minY; i--) {
                    result.add(matrix[maxX][i]);
                }
                maxX--;

                for(int i = maxX; i >= minX; i--) {
                    result.add(matrix[i][minY]);
                }
                minY++;
            }

            return result;
        }
    }
}
