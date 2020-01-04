package com.sp4beans.leetcode.easy;

//        给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
//
//        通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
//
//         
//
//        示例 1：
//
//        输入：date = "2019-01-09"
//        输出：9
//        示例 2：
//
//        输入：date = "2019-02-10"
//        输出：41
//        示例 3：
//
//        输入：date = "2003-03-01"
//        输出：60
//        示例 4：
//
//        输入：date = "2004-03-01"
//        输出：61

public class P1154 {

    private static class Solution {
        public int dayOfYear(String date) {
            int[] dayCount = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            String[] dates = date.split("-");
            int year = Integer.parseInt(dates[0]);
            boolean flag = isYear(year);
            int days = 0;
            int month = Integer.parseInt(dates[1]);
            for (int i = 0; i < month - 1; i++) {
                days += dayCount[i];
            }
            days += Integer.parseInt(dates[2]);
            return flag && month > 2 ? days + 1 : days;

        }

        public boolean isYear(int year) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return year % 4 == 0;
            }
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.dayOfYear("2019-01-09"));
        System.out.println(solution.dayOfYear("2019-02-10"));
        System.out.println(solution.dayOfYear("2003-03-01"));
        System.out.println(solution.dayOfYear("2004-03-01"));
    }
}
