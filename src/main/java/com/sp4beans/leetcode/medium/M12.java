package com.sp4beans.leetcode.medium;

//
// 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
//
//        [["a","b","c","e"],
//        ["s","f","c","s"],
//        ["a","d","e","e"]]
//
//        但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
//
//         
//
//        示例 1：
//
//        输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//        输出：true
//        示例 2：
//
//        输入：board = [["a","b"],["c","d"]], word = "abcd"
//        输出：false
//        提示：
//
//        1 <= board.length <= 200
//        1 <= board[i].length <= 200
//        注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/

public class M12 {
    private static class Solution {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.exist(new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(solution.exist(new char[][] {{'a', 'b'}, {'c', 'd'}}, "abcd"));
        System.out.println(solution.exist(new char[][] {{'a'}, {'a'}}, "aaa"));

    }
}
