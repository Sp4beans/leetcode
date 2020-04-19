package com.sp4beans.leetcode.medium;

//        设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
//
//
//
//        网格中的障碍物和空位置分别用 1 和 0 来表示。
//
//        返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。
//
//        示例 1:
//
//        输入:
//        [
//          [0,0,0],
//          [0,1,0],
//          [0,0,0]
//        ]
//        输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
//        解释:
//        输入中标粗的位置即为输出表示的路径，即
//        0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
//        说明：r 和 c 的值均不超过 100。

import java.util.ArrayList;
import java.util.List;

public class M08_02 {

    private class Solution {
        int[][] grid;
        int length;
        int width;
        public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
            this.grid = obstacleGrid;
            List<List<Integer>> result = new ArrayList<>();
            int[] cur = new int[]{0, 0};
            length = obstacleGrid.length;
            width = obstacleGrid[0].length;
            helper(cur, new boolean[length][width], result);
            return result;
        }

        private boolean helper(int[] cur, boolean[][] visited, List<List<Integer>> path) {
            if (cur[0] >= length || cur[1] >= width) {
                return false;
            }

            if (visited[cur[0]][cur[1]]) {
                return false;
            }

            if (grid[cur[0]][cur[1]] == 0) {
                List<Integer> curNode = new ArrayList<>();
                curNode.add(cur[0]);
                curNode.add(cur[1]);
                path.add(curNode);
                visited[cur[0]][cur[1]] = true;
            } else {
                return false;
            }

            if (cur[0] == length - 1 && cur[1] == width - 1) {
                return true;
            }

            boolean success = helper(new int[]{cur[0], cur[1] + 1}, visited, path)
                    || helper(new int[]{cur[0] + 1, cur[1]}, visited, path);
            if (!success && !path.isEmpty()) {
                path.remove(path.size() - 1);
            }
            return success;
        }
    }

}
