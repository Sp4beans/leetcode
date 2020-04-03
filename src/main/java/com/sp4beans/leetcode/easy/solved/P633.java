package com.sp4beans.leetcode.easy.solved;

//        给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
//
//        示例1:
//
//        输入: 5
//        输出: True
//        解释: 1 * 1 + 2 * 2 = 5
//         
//
//        示例2:
//
//        输入: 3
//        输出: False

import java.util.HashSet;

public class P633 {
    private static class Solution {
        public boolean judgeSquareSum(int c) {
            HashSet<Long> set = new HashSet<>();
            for (long i = 0; i * i <= c; i++) {
                long cur = i * i;
                set.add(cur);
                if (set.contains(c - cur)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.judgeSquareSum(5));
        System.out.println(solution.judgeSquareSum(3));
        System.out.println(solution.judgeSquareSum(2147482647));
    }
}
