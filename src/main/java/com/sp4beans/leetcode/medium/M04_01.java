package com.sp4beans.leetcode.medium;

//        节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
//
//        示例1:
//
//        输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
//        输出：true
//        示例2:
//
//        输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
//        输出 true
//        提示：
//
//        节点数量n在[0, 1e5]范围内。
//        节点编号大于等于 0 小于 n。
//        图中可能存在自环和平行边。

import java.util.LinkedList;

public class M04_01 {
    private class Solution {
        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
            boolean[][] map = new boolean[n][n];
            for (int[] path : graph) {
                map[path[0]][path[1]] = true;
            }
            boolean[] shown = new boolean[n];
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(start);
            while (!queue.isEmpty()) {
                int cur = queue.removeFirst();
                if (cur == target) {
                    return true;
                }
                if (!shown[cur]) {
                    shown[cur] = true;
                    for (int i = 0; i < n; i++) {
                        if (map[cur][i]) {
                            if (i == target) {
                                return true;
                            }
                            if (!shown[i]) {
                                queue.add(i);
                            }
                        }
                    }
                }
            }

            return false;
        }
    }
}
