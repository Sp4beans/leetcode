package com.sp4beans.leetcode.easy.solved;

//        给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
//
//        示例:
//
//        MovingAverage m = new MovingAverage(3);
//        m.next(1) = 1
//        m.next(10) = (1 + 10) / 2
//        m.next(3) = (1 + 10 + 3) / 3
//        m.next(5) = (10 + 3 + 5) / 3

public class P346 {
    private class MovingAverage {

        int[] data;
        int idxStart;
        int idxEnd;
        double curSum;
        int len;
        int curLen;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            data = new int[size];
            len = size;
            idxStart = 0;
            idxEnd = 0;
            curLen = 0;
        }

        public double next(int val) {
            if (curLen == len) {
                curSum -= data[idxStart];
                idxStart = (idxStart + 1) % len;
                curLen--;
            }

            data[idxEnd] = val;
            curSum += val;
            idxEnd = (idxEnd + 1) % len;
            curLen++;

            return curSum / curLen;
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
