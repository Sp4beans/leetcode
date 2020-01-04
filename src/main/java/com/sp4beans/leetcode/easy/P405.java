package com.sp4beans.leetcode.easy;

//        给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
//
//        注意:
//
//        十六进制中所有字母(a-f)都必须是小写。
//        十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
//        给定的数确保在32位有符号整数范围内。
//        不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
//        示例 1：
//
//        输入:
//        26
//
//        输出:
//        "1a"
//        示例 2：
//
//        输入:
//        -1
//
//        输出:
//        "ffffffff"

public class P405 {
    private static class Solution {
        public String toHex(int num) {
            StringBuilder result = new StringBuilder();
            long newNum = num;
            if (newNum < 0) {
                newNum += 4294967296L;
            }
            if (newNum == 0) {
                result.append('0');
            } else {
                while (newNum > 0) {
                    result.append(getChar(newNum));
                    newNum /= 16;
                }
            }
            return result.reverse().toString();
        }

        public char getChar(long n) {
            long ans = n % 16;
            if (ans >= 0 && ans <= 9) {
                return (char) ('0' + ans);
            } else {
                return (char) (ans - 10 + 'a');
            }
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.toHex(26));
        System.out.println(solution.toHex(-1));
    }


}
