package com.sp4beans.leetcode.easy.solved;

//        请你编写一个程序来计算两个日期之间隔了多少天。
//
//        日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
//
//         
//
//        示例 1：
//
//        输入：date1 = "2019-06-29", date2 = "2019-06-30"
//        输出：1
//        示例 2：
//
//        输入：date1 = "2020-01-15", date2 = "2019-12-31"
//        输出：15
//         
//
//        提示：
//
//        给定的日期是 1971 年到 2100 年之间的有效日期。

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class P1360 {
    private static class Solution {
        public int daysBetweenDates(String date1, String date2) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                long dateA = dateFormat.parse(date1).getTime();
                long dateB = dateFormat.parse(date2).getTime();
                return (int) (Math.abs(dateA - dateB) / TimeUnit.DAYS.toMillis(1));
            } catch (Exception e) {
                return 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.daysBetweenDates("2019-06-29", "2019-06-30"));
        System.out.println(solution.daysBetweenDates("2020-01-15", "2019-12-31"));
    }
}
