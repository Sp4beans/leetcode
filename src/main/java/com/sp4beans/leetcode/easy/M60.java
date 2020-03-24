package com.sp4beans.leetcode.easy;

//        把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
//
//         
//
//        你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
//
//         
//
//        示例 1:
//
//        输入: 1
//        输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
//        示例 2:
//
//        输入: 2
//        输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
//         
//
//        限制：
//
//        1 <= n <= 11

public class M60 {

    private static class Solution {
        public double[] twoSum(int n) {
            int[][] count = new int[n + 1][6 * n + 1];
            double[] ans = new double[n * 5 + 1];

            for (int i = 1; i <= 6; i++) {
                count[1][i] = 1;
            }

            for (int k = 1; k < n; k++) {
                for (int i = 1; i <= 6; i++) {
                    for (int j = k; j <= k * 6; j++) {
                        count[k + 1][i + j] += count[k][j];
                    }
                }
            }

            double base = Math.pow(6.0f, -n);

            int index = 0;
            for (int i = n; i <= 6 * n; i++) {
                ans[index++] = count[n][i] * base;
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.twoSum(3);
    }

}
