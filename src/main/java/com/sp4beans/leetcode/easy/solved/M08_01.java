package com.sp4beans.leetcode.easy.solved;

//        三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
//
//        示例1:
//
//        输入：n = 3
//        输出：4
//        说明: 有四种走法
//        示例2:
//
//        输入：n = 5
//        输出：13
//        提示:
//
//        n范围在[1, 1000000]之间

public class M08_01 {

    private class Solution {

        int MOD = 1000000007;

        public int waysToStep(int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int[] steps = new int[n + 1];
            steps[0] = 1;
            steps[1] = 1;
            steps[2] = 2;
            for (int i = 3; i <= n; i++) {
                steps[i] = ((steps[i-1] + steps[i-2]) % MOD + steps[i-3]) % MOD;
            }

            return steps[n];
        }
    }
}
