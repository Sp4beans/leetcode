package com.sp4beans.leetcode.easy.solved;

//        给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，请你判断一个人是否能够参加这里面的全部会议。
//
//        示例 1:
//
//        输入: [[0,30],[5,10],[15,20]]
//        输出: false
//        示例 2:
//
//        输入: [[7,10],[2,4]]
//        输出: true


import java.util.Arrays;

public class P252 {

    private static class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            });

            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < intervals[i - 1][1]) return false;
            }

            return true;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(solution.canAttendMeetings(new int[][]{{7, 10}, {2, 4}}));
    }

}
