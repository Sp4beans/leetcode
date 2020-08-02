package com.sp4beans.leetcode.medium.solved;

//        在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
//
//        请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
//
//         
//
//        示例 1：
//
//        输入：[1,1,1,2,2,2]
//        输出：[2,1,2,1,2,1]
//        示例 2：
//
//        输入：[1,1,1,1,2,2,3,3]
//        输出：[1,3,1,3,2,1,2,1]
//         
//
//        提示：
//
//        1 <= barcodes.length <= 10000
//        1 <= barcodes[i] <= 10000

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class P1054 {
    private class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int b : barcodes) {
                if (map.containsKey(b)) {
                    map.put(b, map.get(b) + 1);
                } else {
                    map.put(b, 1);
                }
            }

            PriorityQueue<Entry<Integer, Integer>> pq =
                    new PriorityQueue<>((a, b) ->
                            a.getValue().equals(b.getValue()) ? b.getKey() - a.getKey() :
                            b.getValue() - a.getValue());
            // 构造堆
            for (Map.Entry e : map.entrySet()) {
                pq.offer(e);
            }
            int[] reslut = new int[barcodes.length];
            int i = 0;
            // 交替
            while (pq.size() > 1) {

                Map.Entry<Integer, Integer> e = pq.poll();
                Map.Entry<Integer, Integer> e1 = pq.poll();
                reslut[i++] = e.getKey();
                reslut[i++] = e1.getKey();
                int numE = e.getValue() - 1;
                int numE1 = e1.getValue() - 1;
                if (numE > 0) {
                    e.setValue(numE);
                    pq.offer(e);
                }
                if (numE1 > 0) {
                    e1.setValue(numE1);
                    pq.offer(e1);
                }
            }
            if (pq.size() == 1) {
                reslut[i] = pq.poll().getKey();
            }
            return reslut;
        }
    }
}
