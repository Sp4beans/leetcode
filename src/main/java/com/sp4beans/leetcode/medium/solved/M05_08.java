package com.sp4beans.leetcode.medium.solved;

//        绘制直线。有个单色屏幕存储在一个一维数组中，使得32个连续像素可以存放在一个 int 里。屏幕宽度为w，且w可被32整除（即一个 int 不会分布在两行上），屏幕高度可由数组长度及屏幕宽度推算得出。请实现一个函数，绘制从点(x1, y)到点(x2, y)的水平线。
//
//        给出数组的长度 length，宽度 w（以比特为单位）、直线开始位置 x1（比特为单位）、直线结束位置 x2（比特为单位）、直线所在行数 y。返回绘制过后的数组。
//
//        示例1:
//
//        输入：length = 1, w = 32, x1 = 30, x2 = 31, y = 0
//        输出：[3]
//        说明：在第0行的第30位到第31为画一条直线，屏幕表示为[0b000000000000000000000000000000011]
//        示例2:
//
//        输入：length = 3, w = 96, x1 = 0, x2 = 95, y = 0
//        输出：[-1, -1, -1]

public class M05_08 {
    private static class Solution {
        public int[] drawLine(int length, int w, int x1, int x2, int y) {
            int tarMin = y*w+x1;
            int tarMax= y*w+x2;
            int[] ans = new int[length];
            for(int i = 0; i<length && tarMin <= tarMax; i++) {
                int curMin = i * 32;
                int curMax = i * 32 + 31;
                if (tarMin >= curMin && tarMin <= curMax) {
                    if (tarMax >= curMin && tarMax <= curMax) {
                        ans[i] = getValue(tarMin - curMin, tarMax - curMin);
                    } else {
                        ans[i] = getValue(tarMin - curMin, 31);
                        tarMin = curMax + 1;
                    }
                }
                System.out.println(ans[i]);
            }
            return ans;
        }

        private int getValue(int startIndex, int endIndex) {
            if (endIndex - startIndex + 1 == 32) {
                return -1;
            }
            int oneLength = endIndex - startIndex + 1;
            int ans = (1 << oneLength) - 1;
            int moveLeft = 32 - endIndex - 1;
            ans = ans << moveLeft;
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.drawLine(9, 32, 29, 29, 5));
    }
}
