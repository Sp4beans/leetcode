package com.sp4beans.leetcode.easy.solved;

//        在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
//
//        请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
//
//         
//
//        示例 1：
//
//
//
//        输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//        输出：true
//        示例 2：
//
//
//
//        输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//        输出：false
//         
//
//        提示：
//
//        2 <= coordinates.length <= 1000
//        coordinates[i].length == 2
//        -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
//        coordinates 中不含重复的点

public class P1232 {

    private static class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            int dx = 0;
            int dy = 0;
            for(int i = 1; i < coordinates.length; i++) {
                if (i == 1) {
                    dx = coordinates[i][0] - coordinates[i-1][0];
                    dy = coordinates[i][1] - coordinates[i-1][1];
                } else {
                    int dx1 = coordinates[i][0] - coordinates[i-1][0];
                    int dy1 = coordinates[i][1] - coordinates[i-1][1];
                    if (dx1 * dy != dy1 * dx) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkStraightLine(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}));
        System.out.println(solution.checkStraightLine(new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{6,7}}));
        System.out.println(solution.checkStraightLine(new int[][]{{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}}));
    }
}
