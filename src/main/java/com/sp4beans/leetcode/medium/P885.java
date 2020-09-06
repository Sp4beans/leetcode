package com.sp4beans.leetcode.medium;

//        在 R 行 C 列的矩阵上，我们从 (r0, c0) 面朝东面开始
//
//        这里，网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
//
//        现在，我们以顺时针按螺旋状行走，访问此网格中的每个位置。
//
//        每当我们移动到网格的边界之外时，我们会继续在网格之外行走（但稍后可能会返回到网格边界）。
//
//        最终，我们到过网格的所有 R * C 个空间。
//
//        按照访问顺序返回表示网格位置的坐标列表。
//
//         
//
//        示例 1：
//
//        输入：R = 1, C = 4, r0 = 0, c0 = 0
//        输出：[[0,0],[0,1],[0,2],[0,3]]
//
//
//         
//
//        示例 2：
//
//        输入：R = 5, C = 6, r0 = 1, c0 = 4
//        输出：[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],
// [4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
//
//
//         
//
//        提示：
//
//        1 <= R <= 100
//        1 <= C <= 100
//        0 <= r0 < R
//        0 <= c0 < C

import java.util.ArrayList;
import java.util.List;

public class P885 {
    private class Solution {
        public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
            int[][] ans = new int[R][C];
            List<int[]> result = new ArrayList<>();
            int dir = 0; // 0 right, 1 down, 2 left, 3 up;
            int i = 1;
            int r = r0, c = c0;

            int k = 1;
            ans[r][c] = i++;
            result.add(new int[] {r, c});
            while (i <= R * C) {
                for (int j = 0; j < k; j++) {
                    switch (dir) {
                        case 0:
                            c++;
                            break;
                        case 1:
                            r++;
                            break;
                        case 2:
                            c--;
                            break;
                        case 3:
                            r--;
                            break;
                        default:
                            break;
                    }
                    if (r >= 0 && r < R && c >= 0 && c < C) {
                        if (ans[r][c] == 0) {
                            ans[r][c] = i++;
                            result.add(new int[] {r, c});
                        }
                    }
                }
                dir = (dir + 1) % 4;
                if (dir % 2 == 0) {
                    k++;
                }
            }

            int[][] res = new int[result.size()][2];
            int ansIdx = 0;
            for (int[] item : result) {
                res[ansIdx++] = item;
            }
            return res;
        }
    }
}
