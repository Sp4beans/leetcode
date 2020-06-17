package com.sp4beans.leetcode.medium;

//        给出一个区间的集合，请合并所有重叠的区间。
//
//        示例 1:
//
//        输入: [[1,3],[2,6],[8,10],[15,18]]
//        输出: [[1,6],[8,10],[15,18]]
//        解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//        示例 2:
//
//        输入: [[1,4],[4,5]]
//        输出: [[1,5]]
//        解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P56 {
    private class Solution {

        class Node {
            int start;
            int end;
            Node(int[] data) {
                this.start = data[0];
                this.end = data[1];
            }

            public int[] to() {
                return new int[]{start, end};
            }
        }

        public int[][] merge(int[][] intervals) {
            if (intervals.length <= 0) {
                return new int[0][2];
            }

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            List<Node> nodes = new ArrayList<>();

            Node lastNode = null;
            for (int[] cur : intervals) {
                if (lastNode == null) {
                    lastNode = new Node(cur);
                } else {
                    if (cur[0] <= lastNode.end) {
                        lastNode.end = Math.max(lastNode.end, cur[1]);
                    } else {
                        nodes.add(lastNode);
                        lastNode = new Node(cur);
                    }
                }
            }
            nodes.add(lastNode);

            int[][] ans = new int[nodes.size()][];
            int index = 0;
            for (Node node : nodes) {
                ans[index++] = node.to();
            }

            return ans;
        }
    }
}
