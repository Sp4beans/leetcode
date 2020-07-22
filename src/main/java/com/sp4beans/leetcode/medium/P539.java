package com.sp4beans.leetcode.medium;

//        给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
//
//
//        示例 1：
//
//        输入: ["23:59","00:00"]
//        输出: 1
//
//        备注:
//
//        列表中时间数在 2~20000 之间。
//        每个时间取值在 00:00~23:59 之间。

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P539 {
    private class Solution {
        public int findMinDifference(List<String> timePoints) {
            List<Integer> time = timePoints.stream()
                    .map(this::convert)
                    .collect(Collectors.toList());
            time.sort(Comparator.comparingInt(i -> i));
            int minDiff = Integer.MAX_VALUE;
            for (int i = 1; i < time.size(); i++) {
                minDiff = Math.min(minDiff, time.get(i) - time.get(i-1));
            }
            minDiff = Math.min(minDiff, 24 * 60 + time.get(0) - time.get(time.size() - 1));
            return minDiff;
        }

        public int convert(String time) {
            String[] times = time.split(":");
            return Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
        }
    }
}
