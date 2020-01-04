package com.sp4beans.leetcode.hard;

//        n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//        上图为 8 皇后问题的一种解法。
//
//        给定一个整数 n，返回 n 皇后不同的解决方案的数量。
//
//        示例:
//
//        输入: 4
//        输出: 2
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

//y = k*x + b;
//left: x + y = b;
//right: y - x + n = b;

public class P52 {
    private static class Solution {

        int ans = 0;

        public int totalNQueens(int n) {
            int[] result = new int[n];
            boolean[] row = new boolean[n];
            boolean[] col = new boolean[n];
            boolean[] left = new boolean[n + n];
            boolean[] right = new boolean[n + n];

            func(n, result, row, col, left, right, 0);

            return ans;
        }

        public void func(int n, int[] result, boolean[] row, boolean[] col, boolean[] left, boolean[] right, int i) {

            if (i == n) {
                ans++;
                return;
            }

            for (int j = 0; j < n; j++) {
                if (row[i] || col[j] || left[getLeft(i, j)] || right[getRight(i, j, n)]) continue;

                row[i] = true;
                col[j] = true;
                left[getLeft(i, j)] = true;
                right[getRight(i, j, n)] = true;
                result[i] = j;

                func(n, result, row, col, left, right, i + 1);

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

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(4));
    }
}
