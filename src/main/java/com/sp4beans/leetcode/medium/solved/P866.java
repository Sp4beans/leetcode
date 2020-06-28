package com.sp4beans.leetcode.medium.solved;

//        求出大于或等于 N 的最小回文素数。
//
//        回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
//
//        例如，2，3，5，7，11 以及 13 是素数。
//
//        回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
//
//        例如，12321 是回文数。
//
//         
//
//        示例 1：
//
//        输入：6
//        输出：7
//        示例 2：
//
//        输入：8
//        输出：11
//        示例 3：
//
//        输入：13
//        输出：101
//         
//
//        提示：
//
//        1 <= N <= 10^8
//        答案肯定存在，且小于 2 * 10^8。

public class P866 {
    private static class Solution {
        public int primePalindrome(int N) {
            int length = String.valueOf(N).length();
            if (length <= 2) {
                while (!isPalindrome(N) || !isPrime(N)) {
                    N++;
                }
                return N;
            } else {
                int base = length % 2 == 0 ? (int) Math.pow(10, length / 2)
                                           : N / (int) Math.pow(10, length / 2);
                int palindrome = genPalindrome(base);
                while (palindrome < N || !isPrime(palindrome)) {
                    base++;
                    palindrome = genPalindrome(base);
                }
                return palindrome;
            }
        }

        private int genPalindrome(int n) {
            int res = n;
            n /= 10;
            while (n > 0) {
                res = res * 10 + n % 10;
                n /= 10;
            }
            return res;
        }

        private boolean isPrime(int n) {
            if (n == 1) {
                return false;
            }
            if (n == 2) {
                return true;
            }
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }

        private boolean isPalindrome(int n) {
            int m = 0;
            int k = n;
            while (k > 0) {
                m = m * 10 + k % 10;
                k /= 10;
            }
            return m == n;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.primePalindrome(8));
        System.out.println(solution.primePalindrome(9989900));
    }

}
