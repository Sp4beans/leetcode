package com.sp4beans.leetcode.easy.solved;

//        给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 
//
//        请你统计并返回 grid 中 负数 的数目。
//
//         
//
//        示例 1：
//
//        输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//        输出：8
//        解释：矩阵中共有 8 个负数。
//        示例 2：
//
//        输入：grid = [[3,2],[1,0]]
//        输出：0
//        示例 3：
//
//        输入：grid = [[1,-1],[-1,-1]]
//        输出：3
//        示例 4：
//
//        输入：grid = [[-1]]
//        输出：1
//         
//
//        提示：
//
//        m == grid.length
//        n == grid[i].length
//        1 <= m, n <= 100
//        -100 <= grid[i][j] <= 100

public class P1351 {
    private class Solution {
        public int countNegatives(int[][] grid) {
            int height = grid.length;
            int length = grid[0].length;
            int curLength = length;
            int ans = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < curLength; j++) {
                    if (grid[i][j] < 0) {
                        ans += (curLength - j) * (height - i);
                        curLength = j;
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
