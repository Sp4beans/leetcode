package com.sp4beans.leetcode.medium;

//        二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字不在0和1之间，或者无法精确地用32位以内的二进制表示，则打印“ERROR”。
//
//        示例1:
//
//        输入：0.625
//        输出："0.101"
//        示例2:
//
//        输入：0.1
//        输出："ERROR"
//        提示：0.1无法被二进制准确表示
//        提示：
//
//        32位包括输出中的"0."这两位。

public class M05_02 {
    private static class Solution {
        private static final String ERROR = "ERROR";
        public String printBin(double num) {
            StringBuilder result = new StringBuilder("0.");

            double curIndex = 1;
            int count = 0;
            while (num > 0 && count < 31) {
                curIndex = curIndex * 0.5;
                if(num - curIndex >= 0) {
                    num = num - curIndex;
                    result.append("1");
                } else {
                    result.append("0");
                }
                count++;
            }
            if (num == 0) {
                return result.toString();
            }
            return ERROR;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.printBin(0.625f));
        System.out.println(solution.printBin(0.1f));
    }
}
