package com.sp4beans.leetcode.easy;

//        回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
//
//        给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
//
//         
//
//        示例 1：
//
//        输入：[[1,1],[2,3],[3,2]]
//        输出：true
//        示例 2：
//
//        输入：[[1,1],[2,2],[3,3]]
//        输出：false
//         
//
//        提示：
//
//        points.length == 3
//        points[i].length == 2
//        0 <= points[i][j] <= 100

public class P1037 {
    private static class Solution {
        public boolean isBoomerang(int[][] points) {
            int x1 = points[1][0] - points[0][0];
            int x2 = points[2][0] - points[0][0];
            int y1 = points[1][1] - points[0][1];
            int y2 = points[2][1] - points[0][1];
            return x1 * y2 != x2 * y1;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.isBoomerang(new int[][]{{1, 1}, {2, 3}, {3, 2}}));
        System.out.println(solution.isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
    }

}
