package com.sp4beans.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

//        设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
//
//        注意：本题相对原题做了扩展
//
//        示例:
//
//        输入：4
//        输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//        解释: 4 皇后问题存在如下两个不同的解法。
//        [
//         [".Q..",  // 解法 1
//          "...Q",
//          "Q...",
//          "..Q."],
//
//         ["..Q.",  // 解法 2
//          "Q...",
//          "...Q",
//          ".Q.."]
//        ]

public class M08_12 {
    private class Solution {
        private List<List<String>> ans = new ArrayList<>();
        int[] result;
        boolean[] row;
        boolean[] col;
        boolean[] left;
        boolean[] right;

        public List<List<String>> solveNQueens(int n) {
            result = new int[n];
            row = new boolean[n];
            col = new boolean[n];
            left = new boolean[n + n];
            right = new boolean[n + n];

            func(n,0);

            return ans;
        }

        public void func(int n, int i) {

            if (i == n) {

                List<String> item = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    String s = "";
                    for (int k = 0; k < n; k++) {
                        s = s + (k == result[j] ? 'Q' : '.');
                    }
                    item.add(s);
                }
                ans.add(item);

                return;
            }

            for (int j = 0; j < n; j++) {
                if (row[i] || col[j] || left[getLeft(i, j)] || right[getRight(i, j, n)]) continue;

                row[i] = true;
                col[j] = true;
                left[getLeft(i, j)] = true;
                right[getRight(i, j, n)] = true;
                result[i] = j;

                func(n, i + 1);

                row[i] = false;
                col[j] = false;
                left[getLeft(i, j)] = false;
                right[getRight(i, j, n)] = false;
            }
        }

        public int getLeft(int i, int j) {
            return i + j;
        }

        public int getRight(int i, int j, int n) {
            return j - i + n;
        }
    }
}
