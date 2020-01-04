package com.sp4beans.leetcode.easy;

//        假设存在一个 k 位数 N，其每一位上的数字的 k 次幂的总和也是 N，那么这个数是阿姆斯特朗数。
//
//        给你一个正整数 N，让你来判定他是否是阿姆斯特朗数，是则返回 true，不是则返回 false。
//
//         
//
//        示例 1：
//
//        输入：153
//        输出：true
//        示例：
//        153 是一个 3 位数，且 153 = 1^3 + 5^3 + 3^3。
//        示例 2：
//
//        输入：123
//        输出：false
//        解释：
//        123 是一个 3 位数，且 123 != 1^3 + 2^3 + 3^3 = 36。
//         
//
//        提示：
//
//        1 <= N <= 10^8

public class P1134 {
    private static class Solution {
        public boolean isArmstrong(int N) {
            if (N < 0) return false;

            int k = String.valueOf(N).length();

            int tmp = N;
            int ans = 0;
            while (tmp > 0) {
                int a = tmp % 10;
                tmp /= 10;
                ans += pow(a, k);
            }
            return ans == N;
        }

        public int pow(int a, int k) {
            int ans = a;
            for (int i = 0; i < k - 1; i++) {
                ans *= a;
            }
            return ans;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.isArmstrong(153));
        System.out.println(solution.isArmstrong(123));

    }
}
