package com.sp4beans.leetcode.medium;

//        设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
//
//        以下是井字游戏的规则：
//
//        玩家轮流将字符放入空位（" "）中。
//        第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
//        "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
//        当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
//        当所有位置非空时，也算为游戏结束。
//        如果游戏结束，玩家不允许再放置字符。
//        如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
//
//        示例 1：
//
//        输入： board = ["O X"," XO","X O"]
//        输出： "X"
//        示例 2：
//
//        输入： board = ["OOX","XXO","OXO"]
//        输出： "Draw"
//        解释： 没有玩家获胜且不存在空位
//        示例 3：
//
//        输入： board = ["OOX","XXO","OX "]
//        输出： "Pending"
//        解释： 没有玩家获胜且仍存在空位
//        提示：
//
//        1 <= board.length == board[i].length <= 100
//        输入一定遵循井字棋规则

public class M16_04 {
    private class Solution {
        public String tictactoe(String[] board) {
            int length = board[0].length();
            int height = board.length;
            char[][] cboard = new char[length][height];
            for (int i = 0; i < board.length; i++) {
                cboard[i] = board[i].toCharArray();
            }

            char winner = findWinner(cboard);
            boolean space = hasSpace(cboard);
            if (winner != 'D') {
                return "" + winner;
            } else {
                return space ? "Pending" : "Draw";
            }
        }

        public char findWinner(char[][] board) {
            // row
            for (int i = 0; i < board.length; i++) {
                char base = board[i][0];
                if (isRow(board, i)) {
                    return base;
                }
            }
            // row
            for (int i = 0; i < board[0].length; i++) {
                char base = board[0][i];
                if (isCol(board, i)) {
                    return base;
                }
            }

            // cross
            char base = board[0][0];
            if (isA(board)) {
                return base;
            }

            char base2 = board[0][board.length-1];
            if (isB(board)) {
                return base2;
            }

            return 'D';
        }

        private boolean isRow(char[][] board, int rowNumber) {
            char target = board[rowNumber][0];
            if (target == ' ') {
                return false;
            }
            for (int i = 0; i < board[rowNumber].length; i++) {
                if (board[rowNumber][i] != target) {
                    return false;
                }
            }
            return true;
        }

        private boolean isCol(char[][] board, int colNumber) {
            char target = board[0][colNumber];
            if (target == ' ') {
                return false;
            }
            for (int i = 0; i < board.length; i++) {
                if (board[i][colNumber] != target) {
                    return false;
                }
            }
            return true;
        }

        private boolean isA(char[][] board) {
            char target = board[0][0];
            if (target == ' ') {
                return false;
            }
            for (int i = 0; i < board.length; i++) {
                if (target != board[i][i]) {
                    return false;
                }
            }
            return true;
        }

        private boolean isB(char[][] board) {
            char target = board[0][board.length - 1];
            if (target == ' ') {
                return false;
            }
            for (int i = 0; i < board.length; i++) {
                if (target != board[i][board.length - 1 - i]) {
                    return false;
                }
            }
            return true;
        }

        public boolean hasSpace(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == ' ') {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
