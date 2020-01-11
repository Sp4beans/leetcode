package com.sp4beans.leetcode.medium;

//        给定两个表示复数的字符串。
//
//        返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
//
//        示例 1:
//
//        输入: "1+1i", "1+1i"
//        输出: "0+2i"
//        解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
//        示例 2:
//
//        输入: "1+-1i", "1+-1i"
//        输出: "0+-2i"
//        解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
//        注意:
//
//        输入字符串不包含额外的空格。
//        输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 100] 之间。输出也应当符合这种形式。

public class P537 {

    private class Solution {
        public String complexNumberMultiply(String a, String b) {
            int[] ra = getValues(a);
            int[] rb = getValues(b);

            int newA = ra[0] * rb[0] - ra[1] * rb[1];
            int newB = ra[0] * rb[1] + ra[1] * rb[0];
            return String.format("%d+%di", newA, newB);
        }

        public int[] getValues(String s) {
            int[] result = new int[2];
            s = s.substring(0, s.length() -1);
            String[] splits = s.split("\\+");
            for (int i = 0; i < splits.length; i++) {
                String cur = splits[i];
                int ans = 0;
                boolean nag = false;
                for (char c : cur.toCharArray()) {
                    if (c == '-') {
                        nag = true;
                    } else {
                        ans = ans * 10 + (c - '0');
                    }
                }
                result[i] = nag ? -ans : ans;
            }
            return result;
        }
    }
}
