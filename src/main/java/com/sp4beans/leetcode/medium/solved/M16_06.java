package com.sp4beans.leetcode.medium.solved;

//        给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
//
//        示例：
//
//        输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
//        输出： 3，即数值对(11, 8)
//        提示：
//
//        1 <= a.length, b.length <= 100000
//        -2147483648 <= a[i], b[i] <= 2147483647
//        正确结果在区间[-2147483648, 2147483647]内

import java.util.Arrays;

public class M16_06 {
    private class Solution {
        public int smallestDifference(int[] a, int[] b) {
            Arrays.sort(a);
            Arrays.sort(b);
            int idxa = 0;
            int idxb = 0;
            long result = Integer.MAX_VALUE;
            while (idxa < a.length && idxb < b.length) {
                result = Math.min(result, Math.abs((long)b[idxb] - a[idxa]));
                if (idxa == a.length - 1) {
                    idxb++;
                } else if (idxb == b.length - 1) {
                    idxa++;
                } else {
                    long cala = Math.abs((long)b[idxb] - a[idxa + 1]);
                    long calb = Math.abs((long)b[idxb + 1] - a[idxa + 1]);
                    if (cala < calb) {
                        idxa++;
                    } else if (cala > calb) {
                        idxb++;
                    } else {
                        idxa++;
                        idxb++;
                    }
                }
            }
            return (int) result;
        }
    }
}
