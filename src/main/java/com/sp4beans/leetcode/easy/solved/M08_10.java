package com.sp4beans.leetcode.easy.solved;

//        颜色填充。编写函数，实现许多图片编辑软件都支持的“颜色填充”功能。给定一个屏幕（以二维数组表示，元素为颜色值）、一个点和一个新的颜色值，将新颜色值填入这个点的周围区域，直到原来的颜色值全都改变。
//
//        示例1:
//
//        输入：
//        image = [[1,1,1],
//                 [1,1,0],
//                 [1,0,1]]
//        sr = 1, sc = 1, newColor = 2
//        输出：[[2,2,2],
//              [2,2,0],
//              [2,0,1]]
//        解释:
//        在图像的正中间，(坐标(sr,sc)=(1,1)),
//        在路径上所有符合条件的像素点的颜色都被更改成2。
//        注意，右下角的像素没有更改为2，
//        因为它不是在上下左右四个方向上与初始点相连的像素点。
//        说明：
//
//        image 和 image[0] 的长度在范围 [1, 50] 内。
//        给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
//        image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。

import java.util.Stack;

public class M08_10 {
    private class Solution {
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{-1,0,1,0};

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int row = image.length;
            int col = image[0].length;

            int color = image[sr][sc];
            if (newColor == color) {
                return image;
            }
            Stack<Integer[]> stack = new Stack<>();
            stack.push(new Integer[]{sr, sc});

            image[sr][sc] = newColor;
            while (!stack.isEmpty()) {
                Integer[] point = stack.pop();
                for (int i = 0; i < 4; i++) {
                    int newx = point[0] + dx[i];
                    int newy = point[1] + dy[i];
                    if (newx >= 0 && newx < row && newy >= 0 && newy < col && image[newx][newy] == color) {
                        image[newx][newy] = newColor;
                        stack.push(new Integer[]{newx, newy});
                    }
                }
            }

            return image;
        }
    }
}
