package com.sp4beans.leetcode.hard;

//        中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
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
//        示例：
//
//        addNum(1)
//        addNum(2)
//        findMedian() -> 1.5
//        addNum(3)
//        findMedian() -> 2
//        进阶:
//
//        如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
//        如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？

import java.util.Comparator;
import java.util.PriorityQueue;

public class P295 {
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
