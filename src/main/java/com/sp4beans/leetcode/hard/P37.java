package com.sp4beans.leetcode.hard;

//        编写一个程序，通过已填充的空格来解决数独问题。
//
//        一个数独的解法需遵循如下规则：
//
//        数字 1-9 在每一行只能出现一次。
//        数字 1-9 在每一列只能出现一次。
//        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//        空白格用 '.' 表示。
//
//
//
//        一个数独。
//
//
//
//        答案被标成红色。
//
//        Note:
//
//        给定的数独序列只包含数字 1-9 和字符 '.' 。
//        你可以假设给定的数独只有唯一解。
//        给定数独永远是 9x9 形式的。

public class P37 {

    private static class Solution {
        public void solveSudoku(char[][] board) {
            backtrack(board, 0);
        }

        public boolean backtrack(char[][] board, int n) {
            if (n >= 81) {
                return true;
            }
            int i = n / 9, j = n % 9;
            if (board[i][j] == '.') {
                for (int num = 1; num <= 9; num++) {
                    if (isValid(num, board, i, j)) {
                        char cur = board[i][j];
                        board[i][j] = (char) (num + '0');
                        boolean res = backtrack(board, n + 1);
                        if (res) return true;
                        board[i][j] = cur;
                    }
                }
            } else {
                return backtrack(board, n + 1);
            }
            return false;
        }

        public boolean isValid(int num, char[][] board, int i, int j) {
            for (int r = 0; r < 9; r++) {
                if (r != j && board[i][r] == (char) (num + '0')) return false;
                if (r != i && board[r][j] == (char) (num + '0')) return false;
            }

            int ii = i / 3;
            int jj = j / 3;

            for (int r = ii * 3; r < ii * 3 + 3; r++) {
                for (int c = jj * 3; c < jj * 3 + 3; c++) {
                    if (r != i && c != j && board[r][c] == (char) (num + '0')) return false;
                }
            }

            return true;
        }

    }


    public static void main(String args[]) {
        Solution solution = new Solution();

        char[][] sudoku = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

//        char[][] sudoku = new char[][]{
//                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
//                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
//                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
//                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
//                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
//                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
//                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };

        solution.solveSudoku(sudoku);

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

}
