package com.sp4beans.leetcode.easy.solved;

//        给你一个字符串 date ，它的格式为 Day Month Year ，其中：
//
//        Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
//        Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
//        Year 的范围在 ​[1900, 2100] 之间。
//        请你将字符串转变为 YYYY-MM-DD 的格式，其中：
//
//        YYYY 表示 4 位的年份。
//        MM 表示 2 位的月份。
//        DD 表示 2 位的天数。
//         
//
//        示例 1：
//
//        输入：date = "20th Oct 2052"
//        输出："2052-10-20"
//        示例 2：
//
//        输入：date = "6th Jun 1933"
//        输出："1933-06-06"
//        示例 3：
//
//        输入：date = "26th May 1960"
//        输出："1960-05-26"
//         
//
//        提示：
//
//        给定日期保证是合法的，所以不需要处理异常输入。

import java.util.HashMap;
import java.util.Map;

public class P1507 {
    private static class Solution {
        public String reformatDate(String date) {
            Map<String, String> monthMap = new HashMap<>();
            monthMap.put("Jan", "01");
            monthMap.put("Feb", "02");
            monthMap.put("Mar", "03");
            monthMap.put("Apr", "04");
            monthMap.put("May", "05");
            monthMap.put("Jun", "06");
            monthMap.put("Jul", "07");
            monthMap.put("Aug", "08");
            monthMap.put("Sep", "09");
            monthMap.put("Oct", "10");
            monthMap.put("Nov", "11");
            monthMap.put("Dec", "12");

            String[] inputs = date.split(" ");
            int day = 0;
            for (char c : inputs[0].toCharArray()) {
                if (c >= '0' && c <= '9') {
                    day = day * 10 + (c - '0');
                }
            }
            String month = monthMap.get(inputs[1]);
            return String.format("%s-%s-%02d", inputs[2], month, day);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reformatDate("20th Oct 2052"));
        System.out.println(solution.reformatDate("6th Jun 1933"));
        System.out.println(solution.reformatDate("26th May 1960"));
    }

}
