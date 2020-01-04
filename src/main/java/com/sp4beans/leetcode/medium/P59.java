package com.sp4beans.leetcode.medium;

//        给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
//
//        示例:
//
//        输入: 3
//        输出:
//        [
//        [ 1, 2, 3 ],
//        [ 8, 9, 4 ],
//        [ 7, 6, 5 ]
//        ]

public class P59 {
    private static class Solution {
        public int[][] generateMatrix(int n) {
            int idxR = 0;
            int idxC = 0;
            int maxR = n - 1;
            int maxC = n - 1;
            int minR = 1;
            int minC = 0;
            int dir = 0; // 0 right 1 down 2 left 3 up
            int[][] ans = new int[n][n];
            for (int i = 1; i <= n * n; i++) {
                ans[idxR][idxC] = i;
                switch (dir) {
                    case 0:
                        if (idxC < maxC) {
                            idxC++;
                        } else {
                            dir = 1;
                            idxR++;
                            maxC--;
                        }
                        break;
                    case 1:
                        if (idxR < maxR) {
                            idxR++;
                        } else {
                            dir = 2;
                            idxC--;
                            maxR--;
                        }
                        break;
                    case 2:
                        if (idxC > minC) {
                            idxC--;
                        } else {
                            dir = 3;
                            idxR--;
                            minC++;
                        }
                        break;
                    case 3:
                        if (idxR > minR) {
                            idxR--;
                        } else {
                            dir = 0;
                            idxC++;
                            minR++;
                        }
                        break;
                }
            }
            return ans;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        int[][] ans = solution.generateMatrix(4);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

}
