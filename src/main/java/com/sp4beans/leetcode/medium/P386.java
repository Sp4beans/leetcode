package com.sp4beans.leetcode.medium;

//        给定一个整数 n, 返回从 1 到 n 的字典顺序。
//
//        例如，
//
//        给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
//
//        请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。

import java.util.ArrayList;
import java.util.List;

public class P386 {
    private class Solution {
        List<Integer> ans = new ArrayList<>();

        public List<Integer> lexicalOrder(int n) {
            helper(0, n);
            return ans;
        }

        public void helper(int base, int n) {
            if (base > n) {
                return;
            }
            int start = base == 0 ? 1 : 0;
            if (base != 0) {
                ans.add(base);
            }
            for (int i = start; i < 10; i++) {
                int newBase = base * 10 + i;
                if (newBase <= n) {
                    helper(newBase, n);
                }
            }
        }
    }
}
