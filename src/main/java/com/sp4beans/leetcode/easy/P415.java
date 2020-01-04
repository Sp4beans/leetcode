package com.sp4beans.leetcode.easy;

//        给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
//        注意：
//
//        num1 和num2 的长度都小于 5100.
//        num1 和num2 都只包含数字 0-9.
//        num1 和num2 都不包含任何前导零。
//        你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

public class P415 {
    private static class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder result = new StringBuilder();

            int length1 = num1.length();
            int length2 = num2.length();

            int index = 0;
            boolean flag = false;
            while (index < num1.length() && index < num2.length()) {
                int sum = (num1.charAt(length1 - index - 1) - '0') + (num2.charAt(length2 - index - 1) - '0');
                if (flag) {
                    sum += 1;
                }
                if (sum >= 10) {
                    flag = true;
                    sum -= 10;
                } else {
                    flag = false;
                }

                result.append(sum);
                index++;
            }

            while (index < num1.length()) {
                int sum = num1.charAt(length1 - index - 1) - '0';
                if (flag) {
                    sum += 1;
                }
                if (sum >= 10) {
                    flag = true;
                    sum -= 10;
                } else {
                    flag = false;
                }

                result.append(sum);
                index++;
            }

            while (index < num2.length()) {
                int sum = num2.charAt(length2 - index - 1) - '0';
                if (flag) {
                    sum += 1;
                }
                if (sum >= 10) {
                    flag = true;
                    sum -= 10;
                } else {
                    flag = false;
                }

                result.append(sum);
                index++;
            }

            if (flag) {
                result.append(1);
            }

            return result.reverse().toString();

        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.addStrings("123123", "1"));
        System.out.println(solution.addStrings("123123", "98798723"));
    }
}
