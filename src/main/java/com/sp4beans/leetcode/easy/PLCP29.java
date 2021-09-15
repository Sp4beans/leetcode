package com.sp4beans.leetcode.easy;

//        某乐团的演出场地可视作 num * num 的二维矩阵 grid（左上角坐标为 [0,0])，每个位置站有一位成员。乐团共有 9 种乐器，乐器编号为 1~9，每位成员持有 1 个乐器。
//
//        为保证声乐混合效果，成员站位规则为：自 grid 左上角开始顺时针螺旋形向内循环以 1，2，...，9 循环重复排列。例如当 num = 5 时，站位如图所示
//
//
//
//        请返回位于场地坐标 [Xpos,Ypos] 的成员所持乐器编号。
//
//        示例 1：
//
//        输入：num = 3, Xpos = 0, Ypos = 2
//
//        输出：3
//
//        解释：
//
//
//        示例 2：
//
//        输入：num = 4, Xpos = 1, Ypos = 2
//
//        输出：5
//
//        解释：
//
//
//        提示：
//
//        1 <= num <= 10^9
//        0 <= Xpos, Ypos < num

public class PLCP29 {
    private class Solution {
        public int orchestraLayout(int num, int xPos, int yPos) {
            return 0;
        }
        
        private int calc(int row, int col, int xPos, int yPos, int mod) {
            int minRow = 0;
            int minCol = 0;
            int maxRow = row - 1;
            int maxCol = col - 1;
            int base = 0;
            while (xPos >= minRow && xPos <= maxRow && yPos >= minCol && yPos <= maxCol) {
                
            }
            return 0;
        }
    }
}