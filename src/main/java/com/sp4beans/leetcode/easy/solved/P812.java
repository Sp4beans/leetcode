package com.sp4beans.leetcode.easy.solved;

//        给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
//
//        示例:
//        输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
//        输出: 2
//        解释:
//        这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
//
//
//        注意:
//
//        3 <= points.length <= 50.
//        不存在重复的点。
//         -50 <= points[i][j] <= 50.
//        结果误差值在 10^-6 以内都认为是正确答案。

public class P812 {
    private static class Solution {
        public double largestTriangleArea(int[][] points) {
            if (points.length < 3) {
                return 0;
            } else {
                double result = 0;
                for (int i = 0; i < points.length; i++) {
                    for (int j = i + 1; j < points.length; j++) {
                        for (int k = j + 1; k < points.length; k++) {
                            result = Double.max(result, calcArea(points[i], points[j], points[k]));
                        }
                    }
                }
                return result;
            }
        }

        public double calcArea(int[] a, int[] b, int[] c) {
            return 0.5 * Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - a[0] * c[1] - b[0] * a[1] - c[0] * b[1]);
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.print(solution.largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}));
    }
}
