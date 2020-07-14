package com.sp4beans.leetcode.medium;

//        给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
//
//        如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
//
//         
//
//        示例 1：
//
//        输入：1
//        输出：true
//        示例 2：
//
//        输入：10
//        输出：false
//        示例 3：
//
//        输入：16
//        输出：true
//        示例 4：
//
//        输入：24
//        输出：false
//        示例 5：
//
//        输入：46
//        输出：true
//         
//
//        提示：
//
//        1 <= N <= 10^9

import java.util.Arrays;

public class P869 {
    private class Solution {
        public boolean reorderedPowerOf2(int N) {
            int[] curArray = func(N);
            for (int i = 0; i < 31; i++) {
                if (Arrays.equals(curArray, func(1 << i))) {
                    return true;
                }
            }
            return false;
        }

        private int[] func(int n) {
            int[] res = new int[10];
            char[] temp = String.valueOf(n).toCharArray();
            for (int i = 0; i < temp.length; i++) {
                int cur = temp[i] - '0';
                res[cur]++;
            }
            return res;
        }
    }
}
