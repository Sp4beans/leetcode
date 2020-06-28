package com.sp4beans.leetcode.medium;

//        给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
//
//         
//
//        示例 1：
//
//
//
//        输入：hour = 12, minutes = 30
//        输出：165
//        示例 2：
//
//
//
//        输入：hour = 3, minutes = 30
//        输出；75
//        示例 3：
//
//
//
//        输入：hour = 3, minutes = 15
//        输出：7.5
//        示例 4：
//
//        输入：hour = 4, minutes = 50
//        输出：155
//        示例 5：
//
//        输入：hour = 12, minutes = 0
//        输出：0
//         
//
//        提示：
//
//        1 <= hour <= 12
//        0 <= minutes <= 59
//        与标准答案误差在 10^-5 以内的结果都被视为正确结果。

public class P1344 {

    private static class Solution {
        public double angleClock(int hour, int minutes) {
            double hours = (hour + minutes / 60.0) % 12.0;
            double hoursAngle = hours / 12.0 * 360;
            double minutesAngle = minutes / 60.0 * 360;
            double ans = ((minutesAngle - hoursAngle) % 360.0 + 360.0) % 360.0;
            return ans > 180 ? 360 - ans : ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.angleClock(12, 30));
        System.out.println(solution.angleClock(3, 30));
        System.out.println(solution.angleClock(3, 15));
        System.out.println(solution.angleClock(4, 50));
        System.out.println(solution.angleClock(12, 0));
    }

}
