package com.sp4beans.leetcode.medium.solved;

//        将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
//        比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//
//        L   C   I   R
//        E T O E S I I G
//        E   D   H   N
//        之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
//
//        请你实现这个将字符串进行指定行数变换的函数：
//
//        string convert(string s, int numRows);
//        示例 1:
//
//        输入: s = "LEETCODEISHIRING", numRows = 3
//        输出: "LCIRETOESIIGEDHN"
//        示例 2:
//
//        输入: s = "LEETCODEISHIRING", numRows = 4
//        输出: "LDREOEIIECIHNTSG"
//        解释:
//
//        L     D     R
//        E   O E   I I
//        E C   I H   N
//        T     S     G

public class P6 {
    private static class Solution {
        public String convert(String s, int numRows) {
            if (numRows <= 1) {
                return s;
            }

            StringBuilder[] rows = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                rows[i] = new StringBuilder();
            }

            int row = 0;
            boolean dir = false;
            for (char c : s.toCharArray()) {
                rows[row].append(c);
                if (dir) {
                    row--;
                    if (row == 0) {
                        dir = false;
                    }
                } else {
                    row++;
                    if (row == numRows - 1) {
                        dir = true;
                    }
                }
            }

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < numRows; i++) {
                result.append(rows[i]);
            }
            return result.toString();

        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.convert("LEETCODEISHIRING", 3));
        System.out.println(solution.convert("LEETCODEISHIRING", 4));
    }
}
