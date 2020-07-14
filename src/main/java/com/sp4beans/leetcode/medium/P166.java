package com.sp4beans.leetcode.medium;

//        给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
//
//        如果小数部分为循环小数，则将循环的部分括在括号内。
//
//        示例 1:
//
//        输入: numerator = 1, denominator = 2
//        输出: "0.5"
//        示例 2:
//
//        输入: numerator = 2, denominator = 1
//        输出: "2"
//        示例 3:
//
//        输入: numerator = 2, denominator = 3
//        输出: "0.(6)"

import java.util.HashMap;
import java.util.Map;

public class P166 {
    private static class Solution {
        public String fractionToDecimal(int onumerator, int odenominator) {
            boolean negivate = false;
            long numerator = onumerator;
            if (numerator < 0) {
                numerator = -numerator;
                negivate = !negivate;
            }
            long denominator = odenominator;
            if (denominator < 0) {
                denominator = -denominator;
                negivate = !negivate;
            }

            Map<Long, Integer> modMap = new HashMap<>();
            long integer = numerator / denominator;
            long other = numerator % denominator;
            String xiaoshu = "";
            int idx = 0;
            int finIdx = -1;
            while (other != 0) {
                if (modMap.containsKey(other)) {
                    finIdx = modMap.get(other);
                    break;
                }
                modMap.put(other, idx);
                other *= 10;
                long tmp = other / denominator;
                other = other % denominator;
                xiaoshu += tmp;
                idx++;
            }
            StringBuilder result = new StringBuilder();
            if (negivate && numerator != 0) {
                result.append("-");
            }
            result.append(integer);
            if (xiaoshu.length() > 0) {
                result.append(".");
                if (finIdx >= 0) {
                    result.append(xiaoshu.substring(0, finIdx)).append("(")
                            .append(xiaoshu.substring(finIdx, xiaoshu.length())).append(")");
                } else {
                    result.append(xiaoshu);
                }
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fractionToDecimal(1, 2));
        System.out.println(solution.fractionToDecimal(2, 1));
        System.out.println(solution.fractionToDecimal(2, 3));
        System.out.println(solution.fractionToDecimal(1, 3));
        System.out.println(solution.fractionToDecimal(4, 7));
        System.out.println(solution.fractionToDecimal(-1, -2147483648));
    }
}
