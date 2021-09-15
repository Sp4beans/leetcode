package com.sp4beans.leetcode.easy;

//        一个 平方和三元组 (a,b,c) 指的是满足 a2 + b2 = c2 的 整数 三元组 a，b 和 c 。
//
//        给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。
//
//         
//
//        示例 1：
//
//        输入：n = 5
//        输出：2
//        解释：平方和三元组为 (3,4,5) 和 (4,3,5) 。
//        示例 2：
//
//        输入：n = 10
//        输出：4
//        解释：平方和三元组为 (3,4,5)，(4,3,5)，(6,8,10) 和 (8,6,10) 。
//         
//
//        提示：
//
//        1 <= n <= 250

public class P1925 {
    private class Solution {
        public int countTriples(int n) {
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                ans += calc(i);
            }
            return ans;
        }

        public int calc(int n) {
            int ans = 0;
            for (int a = 1; a < n; a++) {
                for (int b = a + 1; b < n; b++) {
                    if (a * a + b * b == n * n) {
                        ans++;
                        if (a != b) {
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }
    }
}
