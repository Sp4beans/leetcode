package com.sp4beans.leetcode.medium.pending;

//        给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。实现一个函数，算出有几种可使该表达式得出
// result 值的括号方法。
//
//        示例 1:
//
//        输入: s = "1^0|0|1", result = 0
//
//        输出: 2
//        解释: 两种可能的括号方法是
//        1^(0|(0|1))
//        1^((0|0)|1)
//        示例 2:
//
//        输入: s = "0&0&0&1^1|0", result = 1
//
//        输出: 10
//        提示：
//
//        运算符的数量不超过 19 个

public class M08_14 {
    private static class Solution {
        public int countEval(String s, int result) {
//            System.out.println("s = " + s);
//            if (s == null) {
//                return 0;
//            }
//            char[] cs = s.toCharArray();
//            if (s.length() == 1) {
//                if (cs[0] == result + '0') {
//                    return 1;
//                } else {
//                    return 0;
//                }
//            }
//            int sum = 0;
//            for (int i = 0; i < s.length() / 2; i++) {
//                char c = calc(cs[i * 2], cs[i * 2 + 1], cs[i * 2 + 2]);
//                String pre = s.substring(0, i * 2);
////                System.out.println("pre = " + pre);
//                String next = s.substring(i * 2 + 3, s.length());
////                System.out.println("next = " + next);
//                sum += countEval(pre + c + next, result);
//            }
//            return sum;
            return 0;
        }

        private char calc(char a, char op, char b) {
            boolean av = a == '1';
            boolean bv = b == '1';
            boolean result = false;
            switch (op) {
                case '&':
                    result = av & bv;
                    break;
                case '|':
                    result = av | bv;
                    break;
                case '^':
                    result = av ^ bv;
                    break;
                default:
                    break;
            }
            return result ? '1' : '0';
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countEval("1^0|0|1", 0));
        System.out.println(solution.countEval("0&0&0&1^1|0", 1));
    }
}
