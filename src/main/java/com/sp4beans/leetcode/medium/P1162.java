package com.sp4beans.leetcode.medium;

//        你现在手里有一份大小为 N x N 的「地图」（网格） grid，上面的每个「区域」（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1
//  代表陆地，请你找出一个海洋区域，这个海洋区域到离它最近的陆地区域的距离是最大的。
//
//        我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
//
//        如果我们的地图上只有陆地或者海洋，请返回 -1。
//
//         
//
//        示例 1：
//
//
//
//        输入：[[1,0,1],[0,0,0],[1,0,1]]
//        输出：2
//        解释：
//        海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
//        示例 2：
//
//
//
//        输入：[[1,0,0],[0,0,0],[0,0,0]]
//        输出：4
//        解释：
//        海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
//         
//
//        提示：
//
//        1 <= grid.length == grid[0].length <= 100
//        grid[i][j] 不是 0 就是 1

import java.util.LinkedList;

public class P1162 {
    private class Solution {
        private class Node {
            int x;
            int y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        int[][] grid;
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};

        public int maxDistance(int[][] grid) {
            this.grid = grid;
            int ans = -1;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int cur = minDistance(i, j);
                    if (cur > 0) {
                        ans = Math.max(ans, cur);
                    }
                }
            }
            return ans;
        }

        private int minDistance(int x, int y) {
            int ans = 0;
            Node node = new Node(x, y);
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            visited[x][y] = true;
            LinkedList<Node> linkedList = new LinkedList<>();
            linkedList.add(node);
            while (!linkedList.isEmpty()) {
                Node cur = linkedList.pollFirst();
                if (grid[cur.x][cur.y] == 1) {
                    return Math.abs(x - cur.x) + Math.abs(y - cur.y);
                }
                for (int i = 0; i < 4; i++) {
                    int newX = cur.x + dx[i];
                    int newY = cur.y + dy[i];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                        if (!visited[newX][newY]) {
                            visited[newX][newY] = true;
                            linkedList.addLast(new Node(newX, newY));
                        }
                    }
                }
            }
            return ans;
        }


    }
}
