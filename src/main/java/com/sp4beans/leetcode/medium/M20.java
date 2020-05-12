package com.sp4beans.leetcode.medium;

//        请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5
// "、"-1E-16"及"12e+5.4"都不是。
//
//         
//
//        注意：本题与主站 65 题相同：https://leetcode-cn.com/problems/valid-number/

//        数字 0-9
//        指数 - "e"
//        正/负号 - "+"/"-"
//        小数点 - "."

public class M20 {
    private static class Solution {
        public boolean isNumber(String s) {
            String pattern = "[ ]*[\\+\\-]?(([0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)|([0-9]+\\.))(e[\\+\\-]?[0-9]+)?[ ]*";
            return s.matches(pattern);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(".".matches("\\.[]]"));
        //        0
        //        0.1
        //        abc
        //        1 a
        //        2e10
        //                -90e3   
        //        1e
        //        e3
        //        6e-1
        //        99e2.5 
        //        53.5e93
        //                --6
        //                -+3
        //        95a54e53
        System.out.println(solution.isNumber("3."));
        System.out.println(solution.isNumber("."));
        System.out.println(solution.isNumber(".1"));
        System.out.println(solution.isNumber("0"));
        System.out.println(solution.isNumber("0.1"));
        System.out.println(solution.isNumber("abc"));
        System.out.println(solution.isNumber("1 a"));
        System.out.println(solution.isNumber("2e10"));
        System.out.println(solution.isNumber("        -90e3   "));
        System.out.println(solution.isNumber("95a54e53"));
        System.out.println(solution.isNumber("-+3"));


    }
}
