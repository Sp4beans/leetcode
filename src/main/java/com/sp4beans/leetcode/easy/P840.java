package com.sp4beans.leetcode.easy;

//        3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
//
//        给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
//
//         
//
//        示例：
//
//        输入: [[4,3,8,4],
//        [9,5,1,9],
//        [2,7,6,2]]
//        输出: 1
//        解释:
//        下面的子矩阵是一个 3 x 3 的幻方：
//        438
//        951
//        276
//
//        而这一个不是：
//        384
//        519
//        762
//
//        总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。

import java.util.HashSet;

public class P840 {
    private static class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int count = 0;
            for (int i = 1; i < grid.length - 1; i++) {
                for (int j = 1; j < grid[i].length - 1; j++) {
                    if (isMagic(grid, i, j)) {
                        count++;
                    }
                }
            }
            return count;
        }

        public boolean isMagic(int[][] grid, int x, int y) {
            if (grid[x][y] != 5) {
                return false;
            }
            if (grid[x - 1][y - 1] + grid[x + 1][y + 1] != 10) {
                return false;
            }
            if (grid[x][y - 1] + grid[x][y + 1] != 10) {
                return false;
            }
            if (grid[x - 1][y - 1] + grid[x - 1][y + 1] + grid[x - 1][y] != 15) {
                return false;
            }
            if (grid[x + 1][y - 1] + grid[x + 1][y + 1] + grid[x + 1][y] != 15) {
                return false;
            }
            if (grid[x - 1][y] + grid[x + 1][y] != 10) {
                return false;
            }
            if (grid[x - 1][y - 1] + grid[x + 1][y - 1] + grid[x][y - 1] != 10) {
                return false;
            }
            if (grid[x - 1][y + 1] + grid[x + 1][y + 1] + grid[x][y + 1] != 10) {
                return false;
            }
            if (grid[x + 1][y - 1] + grid[x - 1][y + 1] != 10) {
                return false;
            }

            HashSet<Integer> set = new HashSet<>();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (grid[x + i][y + j] >= 1 && grid[x + i][y + j] <= 9) {
                        set.add(grid[x + i][y + j]);
                    }
                }
            }
            return set.size() == 9;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.numMagicSquaresInside(new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}}));
    }
}
