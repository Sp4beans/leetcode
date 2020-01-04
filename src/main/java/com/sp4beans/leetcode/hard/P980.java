package com.sp4beans.leetcode.hard;

//        在二维网格 grid 上，有 4 种类型的方格：
//
//        1 表示起始方格。且只有一个起始方格。
//        2 表示结束方格，且只有一个结束方格。
//        0 表示我们可以走过的空方格。
//        -1 表示我们无法跨越的障碍。
//        返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。
//
//         
//
//        示例 1：
//
//        输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
//        输出：2
//        解释：我们有以下两条路径：
//        1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//        2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
//        示例 2：
//
//        输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
//        输出：4
//        解释：我们有以下四条路径：
//        1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
//        2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
//        3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
//        4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
//        示例 3：
//
//        输入：[[0,1],[2,0]]
//        输出：0
//        解释：
//        没有一条路能完全穿过每一个空的方格一次。
//        请注意，起始和结束方格可以位于网格中的任意位置。

public class P980 {

    private static class Solution {

        int ans = 0;

        public int uniquePathsIII(int[][] grid) {

            ans = 0;
            int count = 0;
            int startI = 0;
            int startJ = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        startI = i;
                        startJ = j;
                    } else if (grid[i][j] == 0) {
                        count++;
                    }
                }
            }

            backtrack(startI, startJ, 0, count, grid);
            return ans;
        }

        public void backtrack(int i, int j, int curCount, int maxCount, int[][] grid) {
            if (grid[i][j] == 2 && curCount == maxCount + 1) {
                ans++;
                return;
            }

            int[] dx = new int[]{0, 1, 0, -1};
            int[] dy = new int[]{1, 0, -1, 0};

            int cur = grid[i][j];

            for (int a = 0; a < 4; a++) {

                int ii = i + dx[a];
                int jj = j + dy[a];

                if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && grid[ii][jj] != -1) {
                    grid[i][j] = -1;
                    backtrack(ii, jj, curCount + 1, maxCount, grid);
                    grid[i][j] = cur;
                }
            }
        }
    }


    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
        System.out.println(solution.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}));
        System.out.println(solution.uniquePathsIII(new int[][]{{0, 1}, {2, 0}}));
    }
}
