package com.sp4beans.leetcode.hard;

//        给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
//
//         
//
//        示例：
//
//        给出如下 3x6 的高度图:
//        [
//        [1,4,3,1,3,2],
//        [3,2,1,3,2,4],
//        [2,3,3,2,3,1]
//        ]
//
//        返回 4 。
//
//
//        如上图所示，这是下雨前的高度图[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。
//
//         
//
//
//
//        下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。
//
//         
//
//        提示：
//
//        1 <= m, n <= 110
//        0 <= heightMap[i][j] <= 20000

public class P407 {
    private static class Solution {
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};

        public int trapRainWater(int[][] heightMap) {
            int rows = heightMap.length;
            int cols = heightMap[0].length;
            int[][] maxMap = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    maxMap[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i < rows; i++) {
                int base1 = 0;
                int base2 = 0;
                for (int j = 0; j < cols; j++) {
                    base1 = Math.max(base1, heightMap[i][j]);
                    maxMap[i][j] = Math.min(maxMap[i][j], base1);
                    base2 = Math.max(base2, heightMap[i][cols - 1 - j]);
                    maxMap[i][cols - 1 - j] = Math.min(maxMap[i][cols - 1 - j], base2);
                }
            }
            for (int j = 0; j < cols; j++) {
                int base1 = 0;
                int base2 = 0;
                for (int i = 0; i < rows; i++) {
                    base1 = Math.max(base1, heightMap[i][j]);
                    maxMap[i][j] = Math.min(maxMap[i][j], base1);
                    base2 = Math.max(base2, heightMap[rows - 1 - i][j]);
                    maxMap[rows - 1 - i][j] = Math.min(maxMap[rows - 1 - i][j], base2);
                }
            }

            boolean change = true;
            while (change) {
                change = false;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (maxMap[i][j] != heightMap[i][j]) {
                            int base = maxMap[i][j];
                            for (int k = 0; k < 4; k++) {
                                int ii = i + dx[k];
                                int jj = j + dy[k];
                                if (ii >= 0 && ii < rows && jj >= 0 && jj < cols) {
                                    maxMap[i][j] = Math.min(maxMap[i][j], maxMap[ii][jj]);
                                }
                            }
                            maxMap[i][j] = Math.max(maxMap[i][j], heightMap[i][j]);
                            if (maxMap[i][j] != base) {
                                change = true;
                            }
                        }
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    ans += maxMap[i][j] - heightMap[i][j];
                }
            }

            return ans;
        }
    }

    // [12,13, 1,12],
    // [13, 4,13,12],
    // [13, 8,10,12],
    // [12,13,12,12],
    // [13,13,13,13]

    //            12 13 1 12
    //            13 13 13 12
    //            13 12 12 12
    //            12 13 12 12
    //            13 13 13 13

    // [9,9,9,9,9],
    // [9,2,1,2,9],
    // [9,2,8,2,9],
    // [9,2,3,2,9],
    // [9,9,9,9,9]
    // ans = 57;

    // [9,9,9,9,9],
    // [9,9,9,9,9],
    // [9,9,9,9,9],
    // [9,9,9,9,9],
    // [9,9,9,9,9]

    //    [78,16,94,36],
    //    [87,93,50,22],
    //    [63,28,91,60],
    //    [64,27,41,27],
    //    [73,37,12,69],
    //    [68,30,83,31],
    //    [63,24,68,36]
    // ans = 44

    //            78 16 94 36
    //            87 93 50 22
    //            63 37 91 60
    //            64 37 41 27
    //            73 37 69 69
    //            68 30 83 31
    //            63 24 68 36

    //    [9,9,9,9,9,9,8,9,9,9,9],
    //    [9,0,0,0,0,0,1,0,0,0,9],
    //    [9,0,0,0,0,0,0,0,0,0,9],
    //    [9,0,0,0,0,0,0,0,0,0,9],
    //    [9,9,9,9,9,9,9,9,9,9,9]

    //    215

    //    [9,9,9,9,9,9,8,9,9,9,9],
    //    [9,0,0,0,0,0,1,0,0,0,9],
    //    [9,0,0,0,0,0,0,0,0,0,9],
    //    [9,0,0,0,0,0,0,0,0,0,9],
    //    [9,9,9,9,9,9,9,9,9,9,9]

    //    [14,17,18,16,14,16]
    //    [17, 3,10, 2, 3, 8],
    //    [11,10, 4, 7, 1, 7],
    //    [13, 7, 2, 9, 8,10],
    //    [13, 1, 3, 4, 8, 6],
    //    [20, 3, 3, 9,10, 8]
    //    ans = 25

//            14 17 18 16 14 16
//            17 10 10  7  7  8
//            11 10  4  7  7  7
//            13  7  3  9  7 10
//            13  3  3  3  8  6
//            20  3  3  9  10 8

//    7 + 5 + 4 + 6 + 1 +

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.trapRainWater(
                new int[][] {{12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}});
        System.out.println("ans = " + ans); // 14
        ans = solution.trapRainWater(
                new int[][] {{9, 9, 9, 9, 9}, {9, 2, 1, 2, 9}, {9, 2, 8, 2, 9}, {9, 2, 3, 2, 9}, {9, 9, 9, 9, 9}});
        System.out.println("ans = " + ans); // 57
        ans = solution.trapRainWater(
                new int[][] {{78, 16, 94, 36}, {87, 93, 50, 22}, {63, 28, 91, 60}, {64, 27, 41, 27}, {73, 37, 12, 69},
                        {68, 30, 83, 31}, {63, 24, 68, 36}});
        System.out.println("ans = " + ans); // 44
        ans = solution.trapRainWater(
                new int[][] {{9, 9, 9, 9, 9, 9, 8, 9, 9, 9, 9}, {9, 0, 0, 0, 0, 0, 1, 0, 0, 0, 9},
                        {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9}, {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}});
        System.out.println("ans = " + ans); // 215
        ans = solution.trapRainWater(
                new int[][] {{14, 17, 18, 16, 14, 16}, {17, 3, 10, 2, 3, 8},
                        {11, 10, 4, 7, 1, 7}, {13, 7, 2, 9, 8, 10},
                        {13, 1, 3, 4, 8, 6}, {20, 3, 3, 9, 10, 8}});
        System.out.println("ans = " + ans); // 25

    }
}
