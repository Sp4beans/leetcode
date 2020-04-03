package com.sp4beans.leetcode.easy.solved;

//        给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
//
//        另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
//
//        返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
//
//         
//
//        示例 1：
//
//        输入：R = 1, C = 2, r0 = 0, c0 = 0
//        输出：[[0,0],[0,1]]
//        解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
//        示例 2：
//
//        输入：R = 2, C = 2, r0 = 0, c0 = 1
//        输出：[[0,1],[0,0],[1,1],[1,0]]
//        解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
//        [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
//        示例 3：
//
//        输入：R = 2, C = 3, r0 = 1, c0 = 2
//        输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
//        解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
//        其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
//         
//
//        提示：
//
//        1 <= R <= 100
//        1 <= C <= 100
//        0 <= r0 < R
//        0 <= c0 < C

import java.util.LinkedList;

public class P1030 {
    private static class Solution {
        int x[] = {0, 1, 0, -1};
        int y[] = {1, 0, -1, 0};

        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            int[][] result = new int[R * C][2];
            int[][] used = new int[R][C];
            LinkedList<Integer[]> queue = new LinkedList<>();
            Integer[] start = new Integer[2];
            start[0] = r0;
            start[1] = c0;
            used[r0][c0] = 1;
            queue.addLast(start);

            int index = 0;
            while (!queue.isEmpty()) {
//                System.out.println(index);
                Integer[] curNode = queue.pop();
                if (null == curNode) continue;
                result[index] = new int[2];
                result[index][0] = curNode[0];
                result[index][1] = curNode[1];
                index++;
                for (int i = 0; i < 4; i++) {
                    Integer[] newNode = new Integer[2];
                    newNode[0] = curNode[0] + x[i];
                    newNode[1] = curNode[1] + y[i];
                    if (newNode[0] >= 0 && newNode[0] < R && newNode[1] >= 0 && newNode[1] < C && used[newNode[0]][newNode[1]] != 1) {
                        queue.addLast(newNode);
                        used[newNode[0]][newNode[1]] = 1;
                    }
                }
            }

            return result;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.allCellsDistOrder(1, 2, 0, 0);
        solution.allCellsDistOrder(2, 2, 0, 1);
        solution.allCellsDistOrder(2, 3, 1, 2);
        solution.allCellsDistOrder(2, 3, 1, 2);
    }
}
