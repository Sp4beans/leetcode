package com.sp4beans.leetcode.easy.solved;

//        矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
//
//        如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
//
//        给出两个矩形，判断它们是否重叠并返回结果。
//
//        示例 1：
//
//        输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
//        输出：true
//        示例 2：
//
//        输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
//        输出：false
//        说明：
//
//        两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。
//        矩形中的所有坐标都处于 -10^9 和 10^9 之间。

public class P836 {
    private static class Solution {
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

            int maxX = Integer.max(rec1[0], rec1[2]);
            int maxY = Integer.max(rec1[1], rec1[3]);
            int minX = Integer.min(rec1[0], rec1[2]);
            int minY = Integer.min(rec1[1], rec1[3]);

            int maxX2 = Integer.max(rec2[0], rec2[2]);
            int maxY2 = Integer.max(rec2[1], rec2[3]);
            int minX2 = Integer.min(rec2[0], rec2[2]);
            int minY2 = Integer.min(rec2[1], rec2[3]);

            return (maxY > minY2 && minY < maxY2) && (maxX > minX2 && minX < maxX2);

        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        System.out.println(solution.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
        System.out.println(solution.isRectangleOverlap(new int[]{7, 8, 13, 15}, new int[]{10, 8, 12, 20}));
        System.out.println(solution.isRectangleOverlap(new int[]{5, 15, 8, 18}, new int[]{0, 3, 7, 9}));

    }
}
