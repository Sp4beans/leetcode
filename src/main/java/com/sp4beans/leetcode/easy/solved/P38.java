package com.sp4beans.leetcode.easy.solved;

//        报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
//
//        1.     1
//        2.     11
//        3.     21
//        4.     1211
//        5.     111221
//        1 被读作  "one 1"  ("一个一") , 即 11。
//        11 被读作 "two 1s" ("两个一"）, 即 21。
//        21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
//
//        给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
//
//        注意：整数顺序将表示为一个字符串。

public class P38 {
    private static class Solution {
        public String countAndSay(int n) {
            String result = "1";
            if (n != 1) {
                while (n > 1) {
                    result = countByString(result);
                    n--;
                }
            }
            return result;

        }

        public String countByString(String input) {
            StringBuilder sb = new StringBuilder();

            int count = 0;
            char lastChar = ' ';
            for (int i = 0; i < input.length(); i++) {
                if (i == 0) {
                    count = 1;
                    lastChar = input.charAt(i);
                } else if (input.charAt(i) == lastChar) {
                    count++;
                }

                if (input.charAt(i) != lastChar) {
                    sb.append(count).append(lastChar);
                    lastChar = input.charAt(i);
                    count = 1;
                }
                if (i == input.length() - 1 && input.charAt(i) == lastChar) {
                    sb.append(count).append(lastChar);
                }
            }

            return sb.toString();
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(5));
        System.out.println(solution.countByString("21"));
        System.out.println(solution.countByString("1211"));
    }
}
