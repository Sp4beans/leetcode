package com.sp4beans.leetcode.easy;

//        在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。
//
//        每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
//
//        现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
//
//        投影就像影子，将三维形体映射到一个二维平面上。
//
//        在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
//
//        返回所有三个投影的总面积。
//
//         
//
//        示例 1：
//
//        输入：[[2]]
//        输出：5
//        示例 2：
//
//        输入：[[1,2],[3,4]]
//        输出：17
//        解释：
//        这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。

public class P883 {

    private static class Solution {
        public int projectionArea(int[][] grid) {
            int countZ = 0;
            int countX = 0;
            int countY = 0;

            for (int i = 0; i < grid.length; i++) {
                int[] line = grid[i];
                int maxY = 0;
                int maxX = 0;
                for (int j = 0; j < line.length; j++) {
                    if (grid[i][j] != 0) {
                        countZ++;
                    }
                    maxY = Integer.max(maxY, grid[i][j]);
                    maxX = Integer.max(maxX, grid[j][i]);
                }
                countY += maxY;
                countX += maxX;
            }

            return countX + countY + countZ;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.projectionArea(new int[][]{{2}}));
        System.out.println(solution.projectionArea(new int[][]{{1, 2}, {3, 4}}));
    }
}
