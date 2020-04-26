package com.sp4beans.leetcode.medium;

//        给定N个人的出生年份和死亡年份，第i个人的出生年份为birth[i]，死亡年份为death[i]，实现一个方法以计算生存人数最多的年份。
//
//        你可以假设所有人都出生于1900年至2000年（含1900和2000）之间。如果一个人在某一年的任意时期都处于生存状态，那么他们应该被纳入那一年的统计中。例如，生于1908年、死于1909年的人应当被列入1908
// 年和1909年的计数。
//
//        如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
//
//        示例：
//
//        输入：
//        birth = {1900, 1901, 1950}
//        death = {1948, 1951, 2000}
//        输出： 1901

public class M16_10 {
    private class Solution {
        int offset = 1900;

        public int maxAliveYear(int[] birth, int[] death) {
            int[] temp = new int[1001];
            for (int i = 0; i < birth.length; i++) {
                temp[birth[i] - offset]++;
                temp[death[i] - offset + 1]--;
            }
            int maxCount = 0;
            int baseYear = 0;
            int sum = 0;
            for (int i = 0; i < 500; i++) {
                sum += temp[i];
                if (sum > maxCount) {
                    maxCount = sum;
                    baseYear = i;
                }
            }
            return baseYear + offset;
        }
    }
}
