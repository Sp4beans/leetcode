package com.sp4beans.leetcode.medium;

//        给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
//
//        两数乘积等于  num + 1 或 num + 2
//        以绝对差进行度量，两数大小最接近
//        你可以按任意顺序返回这两个整数。
//
//         
//
//        示例 1：
//
//        输入：num = 8
//        输出：[3,3]
//        解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3 。
//        示例 2：
//
//        输入：num = 123
//        输出：[5,25]
//        示例 3：
//
//        输入：num = 999
//        输出：[40,25]
//         
//
//        提示：
//
//        1 <= num <= 10^9

public class P1362 {
    private class Solution {
        public int[] closestDivisors(int num) {
            int[] a = find(num + 1);
            int[] b = find(num + 2);
            if (Math.abs(a[0]-a[1]) < Math.abs(b[0]-b[1])) {
                return a;
            } else {
                return b;
            }
        }

        public int[] find(int num) {
            for (int i = (int) Math.sqrt(num); i >= 1; i--) {
                if (num % i == 0) {
                    return new int[] {i, num / i};
                }
            }
            return new int[] {1, num};
        }
    }
}
