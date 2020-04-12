package com.sp4beans.leetcode.medium.solved;

//        给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//        示例:
//
//        输入: n = 4, k = 2
//        输出:
//        [
//        [2,4],
//        [3,4],
//        [2,3],
//        [1,2],
//        [1,3],
//        [1,4],
//        ]

import java.util.ArrayList;
import java.util.List;

public class P77 {
    private class Solution {
        public List<List<Integer>> combine(int n, int k) {

            List<List<Integer>> ans = new ArrayList<>();

            if (k > n || k <= 0) {
                return ans;
            }

            for (int i = 0; i <= (1 << n); i++) {
                if (Integer.bitCount(i) == k) {
                    List<Integer> item = new ArrayList<>();
                    for (int j = 1; j <= n; j++) {
                        if (((i >> (j - 1)) & 1) == 1) {
                            item.add(j);
                        }
                    }
                    if (item.size() > 0)
                        ans.add(item);
                }
            }
            return ans;
        }
    }

}
