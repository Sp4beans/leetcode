package com.sp4beans.leetcode.medium;

//        给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
//        单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//         
//
//        示例:
//
//        board =
//        [
//        ['A','B','C','E'],
//        ['S','F','C','S'],
//        ['A','D','E','E']
//        ]
//
//        给定 word = "ABCCED", 返回 true
//        给定 word = "SEE", 返回 true
//        给定 word = "ABCB", 返回 false
//         
//
//        提示：
//
//        board 和 word 中只包含大写和小写英文字母。
//        1 <= board.length <= 200
//        1 <= board[i].length <= 200
//        1 <= word.length <= 10^3

public class P79 {
    private class Solution {
        final int[] dx = new int[] {0, 1, 0, -1};
        final int[] dy = new int[] {1, 0, -1, 0};

        char[][] board;
        boolean[][] visited;
        char[] cs;
        int width;
        int height;

        public boolean exist(char[][] board, String word) {
            if (word == null || word.length() == 0) {
                return false;
            }

            this.width = board.length;
            this.height = board[0].length;
            this.board = board;
            this.cs = word.toCharArray();
            this.visited = new boolean[width][height];

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (board[i][j] == cs[0] && isMatch(i, j, 0)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean isMatch(int i, int j, int k) {
            if (k >= cs.length - 1) {
                return true;
            }
            visited[i][j] = true;
            boolean ans = false;
            for (int ii = 0; ii < dx.length; ii++) {
                int newI = i + dx[ii];
                int newJ = j + dy[ii];
                if (newI >= 0 && newI < width && newJ >= 0 && newJ < height) {
                    if (board[newI][newJ] == cs[k + 1] && !visited[newI][newJ]) {
                        ans = ans || isMatch(newI, newJ, k + 1);
                    }
                }
            }
            if (!ans) {
                visited[i][j] = false;
            }
            return ans;
        }
    }
}
