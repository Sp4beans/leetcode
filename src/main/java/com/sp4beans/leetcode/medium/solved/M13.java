package com.sp4beans.leetcode.medium.solved;

//        地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0]
// 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格
// [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
//         
//
//        示例 1：
//
//        输入：m = 2, n = 3, k = 1
//        输出：3
//        示例 2：
//
//        输入：m = 3, n = 1, k = 0
//        输出：1
//        提示：
//
//        1 <= n,m <= 100
//        0 <= k <= 20

import java.util.LinkedList;

public class M13 {
    private class Solution {

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, 0};

        class Node {
            int x;
            int y;

            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int movingCount(int m, int n, int k) {
            boolean[][] visited = new boolean[m][n];
            Node node = new Node(0, 0);
            int cnt = 0;
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                Node cur = queue.pop();
                if (!visited[cur.x][cur.y] && canMove(cur.x, cur.y, k)) {
                    cnt++;
                    visited[cur.x][cur.y] = true;
                    for (int i = 0; i < 4; i++) {
                        int ii = cur.x + dx[i];
                        int jj = cur.y + dy[i];
                        if (ii >= 0 && ii < m && jj >= 0 && jj < n) {
                            if (!visited[ii][jj] && canMove(ii, jj, k)) {
                                queue.add(new Node(ii, jj));
                            }
                        }
                    }
                }
            }
            return cnt;
        }

        boolean canMove(int i, int j, int k) {
            return calc(i) + calc(j) <= k;
        }

        int calc(int i) {
            int ans = 0;
            while (i > 0) {
                ans += i % 10;
                i /= 10;
            }
            return ans;
        }
    }
}
