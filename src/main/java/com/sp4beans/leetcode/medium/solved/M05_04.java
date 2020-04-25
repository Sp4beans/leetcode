package com.sp4beans.leetcode.medium.solved;

//        下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
//
//        示例1:
//
//        输入：num = 2（或者0b10）
//        输出：[4, 1] 或者（[0b100, 0b1]）
//        示例2:
//
//        输入：num = 1
//        输出：[2, -1]
//        提示:
//
//        num的范围在[1, 2147483647]之间；
//        如果找不到前一个或者后一个满足条件的正数，那么输出 -1。

public class M05_04 {
    private static class Solution {
        public int[] findClosedNumbers(int num) {
            return new int[]{findPre(num), findNext(num)};
        }

        public int findPre(int num) {
            int bitCount = Integer.bitCount(num);
            for (int i = num + 1; i <= Integer.MAX_VALUE; i++) {
                if (Integer.bitCount(i) == bitCount) {
                    return i;
                }
            }
            return -1;
        }

        public int findNext(int num) {
            int bitCount = Integer.bitCount(num);
            for (int i = num - 1; i >= 0; i--) {
                if (Integer.bitCount(i) == bitCount) {
                    return i;
                }
            }
            return -1;
        }
    }
}
