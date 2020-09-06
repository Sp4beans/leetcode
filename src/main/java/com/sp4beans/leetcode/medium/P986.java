package com.sp4beans.leetcode.medium;

//        给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。
//
//        返回这两个区间列表的交集。
//
//        （形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
//
//         
//
//        示例：
//
//
//
//        输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
//        输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

import java.util.ArrayList;
import java.util.List;

public class P986 {
    private class Solution {
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            List<int[]> list = new ArrayList<>();

            int aIdx = 0, bIdx = 0;
            while (aIdx < A.length && bIdx < B.length) {
                int[] arange = A[aIdx];
                int[] brange = B[bIdx];
                int amin = arange[0], amax = arange[1];
                int bmin = brange[0], bmax = brange[1];
                if (amin <= bmin) {
                    if (bmin > amax) {
                        aIdx++;
                    } else if (amax <= bmax) {
                        list.add(new int[] {bmin, amax});
                        aIdx++;
                    } else {
                        list.add(new int[] {bmin, bmax});
                        bIdx++;
                    }
                } else {
                    if (amin > bmax) {
                        bIdx++;
                    } else if (bmax <= amax) {
                        list.add(new int[] {amin, bmax});
                        bIdx++;
                    } else {
                        list.add(new int[]{amin, amax});
                        aIdx++;
                    }
                }
            }

            int[][] ans = new int[list.size()][2];
            int ansIdx = 0;
            for (int[] item : list) {
                ans[ansIdx++] = item;
            }
            return ans;
        }
    }
}
