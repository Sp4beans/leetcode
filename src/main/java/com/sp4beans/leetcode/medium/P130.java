package com.sp4beans.leetcode.medium;

//        给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//
//        找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//
//        示例:
//
//        X X X X
//        X O O X
//        X X O X
//        X O X X
//        运行你的函数后，矩阵变为：
//
//        X X X X
//        X X X X
//        X X X X
//        X O X X
//        解释:
//
//        被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
// 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。


import java.util.Stack;

public class P130 {
    private class Solution {
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};

        private class Node {
            int x;
            int y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public void solve(char[][] board) {
            int rows = board.length;
            if (rows <= 0) {
                return;
            }
            int cols = board[0].length;
            boolean[][] visited = new boolean[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                        if (board[i][j] == 'O' && !visited[i][j]) {
                            visited[i][j] = true;
                            Stack<Node> stack = new Stack<>();
                            stack.push(new Node(i, j));
                            while (!stack.isEmpty()) {
                                Node node = stack.pop();
                                board[node.x][node.y] = 'Y';
                                for (int k = 0; k < 4; k++) {
                                    int newRow = node.x + dx[k];
                                    int newCol = node.y + dy[k];
                                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                                        if (board[newRow][newCol] == 'O' && !visited[newRow][newCol]) {
                                            visited[newRow][newCol] = true;
                                            stack.push(new Node(newRow, newCol));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 'Y') {
                        board[i][j] = 'O';
                    } else {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
}
