package com.sp4beans.leetcode.easy.solved;

//        给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
//        最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
//
//        你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//        示例 1:
//
//        输入: [1,2,3]
//        输出: [1,2,4]
//        解释: 输入数组表示数字 123。
//        示例 2:
//
//        输入: [4,3,2,1]
//        输出: [4,3,2,2]
//        解释: 输入数组表示数字 4321。

public class P66 {

    private class Solution {
        public int[] plusOne(int[] digits) {
            if (digits.length == 0) {
                return new int[]{1};
            }
            digits[digits.length - 1]++;
            int index = digits.length - 1;
            while (index > 0) {
                if (digits[index] >= 10) {
                    digits[index - 1]++;
                    digits[index] %= 10;
                }
                index--;
            }
            if (digits[0] < 10) {
                return digits;
            } else {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                digits[0] %= 10;
                for (int i = 0; i < digits.length; i++) {
                    result[i + 1] = digits[0];
                }
                return result;
            }
        }
    }
}
