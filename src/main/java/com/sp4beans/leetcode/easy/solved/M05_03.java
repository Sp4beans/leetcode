package com.sp4beans.leetcode.easy.solved;

//        给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
//
//        示例 1：
//
//        输入: num = 1775(110111011112)
//        输出: 8
//        示例 2：
//
//        输入: num = 7(01112)
//        输出: 4

public class M05_03 {
    private class Solution {
        public int reverseBits(int num) {
            String bitStr = Integer.toBinaryString(num);
            if (!bitStr.contains("0")) {
                return Math.min(bitStr.length() + 1, 32);
            }
            int max = 1;
            char[] chars = bitStr.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '0') {
                    int count = 1;
                    for (int k = i - 1; k >= 0; k--) {
                        if (chars[k] == '0') break;
                        count++;
                    }
                    for (int k = i + 1; k < chars.length; k++) {
                        if (chars[k] == '0') break;
                        count++;
                    }
                    max = Math.max(max, count);
                }
            }
            return max;
        }
    }
}
