package com.sp4beans.leetcode.hard;

//        如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
//
//        例如，
//
//        [2,3,4] 的中位数是 3
//
//        [2,3] 的中位数是 (2 + 3) / 2 = 2.5
//
//        设计一个支持以下两种操作的数据结构：
//
//        void addNum(int num) - 从数据流中添加一个整数到数据结构中。
//        double findMedian() - 返回目前所有元素的中位数。
//        示例 1：
//
//        输入：
//        ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//        [[],[1],[2],[],[3],[]]
//        输出：[null,null,null,1.50000,null,2.00000]
//        示例 2：
//
//        输入：
//        ["MedianFinder","addNum","findMedian","addNum","findMedian"]
//        [[],[2],[],[3],[]]
//        输出：[null,null,2.00000,null,2.50000]
//         
//
//        限制：
//
//        最多会对 addNum、findMedia进行 50000 次调用。
//        注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-stream/

import java.util.Comparator;
import java.util.PriorityQueue;

public class M41 {
    private class MedianFinder {
        /**
         * initialize your data structure here.
         */
        PriorityQueue<Integer> min; // min.length = max.length || max.length + 1
        PriorityQueue<Integer> max;
        public MedianFinder() {
            min = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            max = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (min.isEmpty() && max.isEmpty()) {
                min.add(num);
            } else {
                double mid = findMedian();
                if (num > mid) {
                    max.add(num);
                } else {
                    min.add(num);
                }
            }
            while (min.size() > max.size() + 1) {
                max.add(min.poll());
            }
            while (max.size() > min.size()) {
                min.add(max.poll());
            }
        }

        public double findMedian() {
            if (min.isEmpty() && max.isEmpty()) {
                return -1;
            }
            if (min.size() > max.size()) {
                return min.peek();
            } else {
                return (min.peek() + max.peek()) / 2.0f;
            }
        }
    }
}
