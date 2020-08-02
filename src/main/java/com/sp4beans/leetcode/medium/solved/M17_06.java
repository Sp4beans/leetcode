package com.sp4beans.leetcode.medium.solved;

//        编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
//
//        示例:
//
//        输入: 25
//        输出: 9
//        解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
//        提示：
//
//        n <= 10^9

public class M17_06 {
    private static class Solution {
        public int numberOf2sInRange(int n) {
            int ans = 0;
            int cur = 0;
            int tmp = n;
            int exp = 1;
            while(tmp > 0) {
                int num = tmp % 10;
                tmp = tmp / 10;
                if (num < 2) {
                    ans = ans + tmp * exp;
                } else if (num == 2) {
                    ans = ans + tmp * exp + cur + 1;
                } else {
                    ans = ans + (tmp + 1) * exp;
                }
                cur = num * exp + cur;
                exp *= 10;
            }
            return ans;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOf2sInRange(25)); // 9
        System.out.println(solution.numberOf2sInRange(100)); // 20
        System.out.println(solution.numberOf2sInRange(251)); // 107

    }
}
