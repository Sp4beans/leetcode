package com.sp4beans.leetcode.medium;

//        给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
//        示例:
//
//        输入: 3
//        输出: 5
//        解释:
//        给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//        1         3     3      2      1
//        \       /     /      / \      \
//        3     2     1      1   3      2
//        /     /       \                 \
//        2     1         2                 3

public class P96 {
    private class Solution {
        public int numTrees(int n) {
            int[] ans = new int[n + 1];
            ans[0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    ans[i] += ans[j] * ans[i-1-j];
                }
            }
            return ans[n];
        }
    }

}
