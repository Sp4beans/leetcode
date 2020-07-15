package com.sp4beans.leetcode.medium;

//        给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
//
//        移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
//
//        返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
//
//         
//
//        示例 1：
//
//        输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//        输出：3
//        解释：
//        有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
//        示例 2：
//
//        输入：[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//        输出：0
//        解释：
//        所有 1 都在边界上或可以到达边界。
//         
//
//        提示：
//
//        1 <= A.length <= 500
//        1 <= A[i].length <= 500
//        0 <= A[i][j] <= 1
//        所有行的大小都相同

import java.util.Stack;

public class P1020 {
    private class Solution {
        int[][] map;
        int[][] delta = new int[][] {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        public int numEnclaves(int[][] A) {
            map = A;

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    help(i, j);
                }
            }

            int ans = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    System.out.print(map[i][j] + " ");
                    ans += map[i][j];
                }
                System.out.println();
            }
            return ans;
        }

        private class Node {
            int x;
            int y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public void help(int x, int y) {
            if (map[x][y] == 1 && (x == 0 || y == 0 || x == map.length - 1 || y == map[0].length - 1)) {
                Node node = new Node(x, y);
                Stack<Node> stack = new Stack<>();
                stack.push(node);
                while (!stack.empty()) {
                    Node cur = stack.pop();
                    map[cur.x][cur.y] = 0;
                    for (int[] d : delta) {
                        int nx = cur.x + d[0];
                        int ny = cur.y + d[1];
                        if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                            if (map[nx][ny] == 1) {
                                stack.push(new Node(nx, ny));
                            }
                        }
                    }
                }
            }
        }
    }
}
