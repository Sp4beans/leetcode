package com.sp4beans.leetcode.easy.solved;

//        给定两个二进制字符串，返回他们的和（用二进制表示）。
//
//        输入为非空字符串且只包含数字 1 和 0。
//
//        示例 1:
//
//        输入: a = "11", b = "1"
//        输出: "100"
//        示例 2:
//
//        输入: a = "1010", b = "1011"
//        输出: "10101"

public class P67 {
    private static class Solution {
        public String addBinary(String a, String b) {
            StringBuilder result = new StringBuilder();

            int indexA = a.length() - 1;
            int indexB = b.length() - 1;

            boolean flag = false;
            while (indexA >= 0 && indexB >= 0) {
                if (a.charAt(indexA) == '1' && b.charAt(indexB) == '1') {
                    if (flag) {
                        result.append('1');
                    } else {
                        result.append('0');
                        flag = true;
                    }
                } else if ((a.charAt(indexA) == '0' && b.charAt(indexB) == '1') || (a.charAt(indexA) == '1' && b.charAt(indexB) == '0')) {
                    if (flag) {
                        result.append('0');
                    } else {
                        result.append('1');
                    }
                } else {
                    if (flag) {
                        result.append('1');
                        flag = false;
                    } else {
                        result.append('0');
                    }
                }
                indexA--;
                indexB--;
            }

            while (indexA >= 0) {
                if (a.charAt(indexA) == '0') {
                    if (flag) {
                        result.append('1');
                        flag = false;
                    } else {
                        result.append('0');
                    }
                } else {
                    if (flag) {
                        result.append('0');
                    } else {
                        result.append('1');
                        flag = false;
                    }
                }

                indexA--;
            }

            while (indexB >= 0) {
                if (b.charAt(indexB) == '0') {
                    if (flag) {
                        result.append('1');
                        flag = false;
                    } else {
                        result.append('0');
                    }
                } else {
                    if (flag) {
                        result.append('0');
                    } else {
                        result.append('1');
                        flag = false;
                    }
                }
                indexB--;
            }

            if (flag) {
                result.append('1');
            }

            return result.reverse().toString();
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("101111", "10"));
        System.out.println(solution.addBinary("11", "1"));
        System.out.println(solution.addBinary("1010", "1011"));
    }
}
