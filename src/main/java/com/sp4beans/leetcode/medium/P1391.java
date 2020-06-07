package com.sp4beans.leetcode.medium;

//        给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：
//
//        1 表示连接左单元格和右单元格的街道。
//        2 表示连接上单元格和下单元格的街道。
//        3 表示连接左单元格和下单元格的街道。
//        4 表示连接右单元格和下单元格的街道。
//        5 表示连接左单元格和上单元格的街道。
//        6 表示连接右单元格和上单元格的街道。
//
//
//        你最开始从左上角的单元格 (0,0) 开始出发，网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、一直到右下方的 (m-1,n-1) 结束的路径。该路径必须只沿着街道走。
//
//        注意：你 不能 变更街道。
//
//        如果网格中存在有效的路径，则返回 true，否则返回 false 。
//
//         
//
//        示例 1：
//
//
//
//        输入：grid = [[2,4,3],[6,5,2]]
//        输出：true
//        解释：如图所示，你可以从 (0, 0) 开始，访问网格中的所有单元格并到达 (m - 1, n - 1) 。
//        示例 2：
//
//
//
//        输入：grid = [[1,2,1],[1,2,1]]
//        输出：false
//        解释：如图所示，单元格 (0, 0) 上的街道没有与任何其他单元格上的街道相连，你只会停在 (0, 0) 处。
//        示例 3：
//
//        输入：grid = [[1,1,2]]
//        输出：false
//        解释：你会停在 (0, 1)，而且无法到达 (0, 2) 。
//        示例 4：
//
//        输入：grid = [[1,1,1,1,1,1,3]]
//        输出：true
//        示例 5：
//
//        输入：grid = [[2],[2],[2],[2],[2],[2],[6]]
//        输出：true
//         
//
//        提示：
//
//        m == grid.length
//        n == grid[i].length
//        1 <= m, n <= 300
//        1 <= grid[i][j] <= 6

import java.util.Stack;

public class P1391 {
    private static class Solution {
        // up right down left
        boolean[][] valid = new boolean[][] {
                {false, false, false, false},
                {false, true, false, true},
                {true, false, true, false},
                {false, false, true, true},
                {false, true, true, false},
                {true, false, false, true},
                {true, true, false, false},
        };
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};

        class Node {
            int x;
            int y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public boolean hasValidPath(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            boolean[][] visited = new boolean[rows][cols];
            Stack<Node> stack = new Stack<>();
            stack.push(new Node(0, 0));
            visited[0][0] = true;
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                if (cur.x == rows - 1 && cur.y == cols - 1) {
                    return true;
                }
                int type = grid[cur.x][cur.y];
                boolean[] validType = valid[type];
                for (int i = 0; i < 4; i++) {
                    int newX = cur.x + dx[i];
                    int newY = cur.y + dy[i];
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                        if (!visited[newX][newY]) {
                            int newType = grid[newX][newY];
                            boolean[] newValidType = valid[newType];
                            if ((validType[0] && newValidType[2] && newX == cur.x - 1) ||
                                    (validType[2] && newValidType[0] && newX == cur.x + 1) ||
                                    (validType[1] && newValidType[3] && newY == cur.y + 1) ||
                                    (validType[3] && newValidType[1]) && newY == cur.y - 1) {
                                visited[newX][newY] = true;
                                stack.push(new Node(newX, newY));
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    //    [[1,1,1,1,6]
    //    ,[1,1,1,1,2],
    //     [1,1,1,1,2],
    //     [1,1,1,1,2],
    //     [1,1,1,1,2]]
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasValidPath(
                new int[][] {{1, 1, 1, 1, 6}, {1, 1, 1, 1, 2}, {1, 1, 1, 1, 2}, {1, 1, 1, 1, 2}, {1, 1, 1, 1, 2}}));
    }
}
