package com.sp4beans.leetcode.easy;

//        给你一个仅由数字 6 和 9 组成的正整数 num。
//
//        你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
//
//        请返回你可以得到的最大数字。
//
//         
//
//        示例 1：
//
//        输入：num = 9669
//        输出：9969
//        解释：
//        改变第一位数字可以得到 6669 。
//        改变第二位数字可以得到 9969 。
//        改变第三位数字可以得到 9699 。
//        改变第四位数字可以得到 9666 。
//        其中最大的数字是 9969 。
//        示例 2：
//
//        输入：num = 9996
//        输出：9999
//        解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
//        示例 3：
//
//        输入：num = 9999
//        输出：9999
//        解释：无需改变就已经是最大的数字了。
//         
//
//        提示：
//
//        1 <= num <= 10^4
//        num 每一位上的数字都是 6 或者 9 。

public class P1323 {

    private static class Solution {
        public int maximum69Number (int num) {
            String numStr = String.valueOf(num);
            int idx6 = numStr.indexOf('6');
            if (idx6 >= 0) {
                numStr = numStr.replaceFirst("6", "9");
            }
            return Integer.valueOf(numStr);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximum69Number(9669));
        System.out.println(solution.maximum69Number(9996));
        System.out.println(solution.maximum69Number(9999));
    }
}
