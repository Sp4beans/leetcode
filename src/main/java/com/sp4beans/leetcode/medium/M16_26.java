package com.sp4beans.leetcode.medium;

//        给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
//
//        表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
//
//        示例 1:
//
//        输入: "3+2*2"
//        输出: 7
//        示例 2:
//
//        输入: " 3/2 "
//        输出: 1
//        示例 3:
//
//        输入: " 3+5 / 2 "
//        输出: 5
//        说明：
//
//        你可以假设所给定的表达式都是有效的。
//        请不要使用内置的库函数 eval。

import java.util.Stack;

public class M16_26 {
    private static class Solution {
        public int calculate(String s) {
            s = s.replaceAll(" ", "");
            Stack<Integer> stack = new Stack<>();
            char lastOp = '+';
            int curVal = 0;
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    curVal = curVal * 10 + (c - '0');
                } else {
                    switch (lastOp) {
                        case '+':
                            stack.push(curVal);
                            break;
                        case '-':
                            stack.push(-curVal);
                            break;
                        case '*':
                            stack.push(stack.pop() * curVal);
                            break;
                        case '/':
                            stack.push(stack.pop() / curVal);
                            break;
                    }

                    lastOp = c;
                    curVal = 0;
                }
            }
            if (curVal != 0) {
                switch (lastOp) {
                    case '+':
                        stack.push(curVal);
                        break;
                    case '-':
                        stack.push(-curVal);
                        break;
                    case '*':
                        stack.push(stack.pop() * curVal);
                        break;
                    case '/':
                        stack.push(stack.pop() / curVal);
                        break;
                }
            }

            int ans = 0;
            while(!stack.isEmpty()) {
                ans += stack.pop();
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("3+2*2")); // 7
        System.out.println(solution.calculate(" 3/2 ")); // 1
        System.out.println(solution.calculate(" 3+5 / 2 ")); // 5
        System.out.println(solution.calculate("1+1+1")); // 3
        System.out.println(solution.calculate("0-2147483647")); // 1
        System.out.println(solution.calculate("2-3+4"));
        System.out.println(solution.calculate("2-3-4"));
    }
}
