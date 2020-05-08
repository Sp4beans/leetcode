package com.sp4beans.leetcode.medium;

//        你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0
// 则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
//
//        示例：
//
//        输入：
//        [
//        [0,2,1,0],
//        [0,1,0,1],
//        [1,1,0,1],
//        [0,1,0,1]
//        ]
//        输出： [1,2,4]
//        提示：
//
//        0 < len(land) <= 1000
//        0 < len(land[i]) <= 1000

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class M16_19 {
    private class Solution {

        int[] dx = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};

        private class Node {
            public int x;
            public int y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int[] pondSizes(int[][] land) {
            List<Integer> ans = new ArrayList<>();
            int maxX = land.length;
            int maxY = land[0].length;
            boolean[][] visited = new boolean[land.length][land[0].length];
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[i].length; j++) {
                    if (land[i][j] == 0 && !visited[i][j]) {
                        int cnt = 0;
                        LinkedList<Node> queue = new LinkedList<>();
                        queue.add(new Node(i, j));
                        while (!queue.isEmpty()) {
                            Node cur = queue.pop();
                            if (!visited[cur.x][cur.y]) {
                                cnt++;
                                visited[cur.x][cur.y] = true;
                                for (int ii = 0; ii < dx.length; ii++) {
                                    int tmpX = cur.x + dx[ii];
                                    int tmpY = cur.y + dy[ii];
                                    if (tmpX >= 0 && tmpX < maxX && tmpY >= 0 && tmpY < maxY) {
                                        if (land[tmpX][tmpY] == 0 && !visited[tmpX][tmpY]) {
                                            queue.push(new Node(tmpX, tmpY));
                                        }
                                    }
                                }
                            }
                        }
                        ans.add(cnt);
                    }
                }
            }

            int[] res = new int[ans.size()];
            int index = 0;
            for (int cnt : ans) {
                res[index++] = cnt;
            }
            Arrays.sort(res);
            return res;
        }
    }
}
