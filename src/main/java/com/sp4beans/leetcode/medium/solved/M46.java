package com.sp4beans.leetcode.medium.solved;

//        给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成
// “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
//
//         
//
//        示例 1:
//
//        输入: 12258
//        输出: 5
//        解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
//         
//
//        提示：
//
//        0 <= num < 2^31

public class M46 {
    private static class Solution {
        public int translateNum(int num) {
            char[] str = String.valueOf(num).toCharArray();
            int[] cnt = new int[str.length];
            cnt[0] = 1;
            for (int i = 1; i < str.length; i++) {
                if (str[i - 1] == '1') {
                    cnt[i] = cnt[i - 1];
                    if (i >= 2) {
                        cnt[i] += cnt[i - 2];
                    } else {
                        cnt[i] += 1;
                    }
                } else if (str[i - 1] == '2') {
                    if (str[i] >= '0' && str[i] <= '5') {
                        cnt[i] = cnt[i - 1];
                        if (i >= 2) {
                            cnt[i] += cnt[i - 2];
                        } else {
                            cnt[i] += 1;
                        }
                    } else {
                        cnt[i] = cnt[i - 1];
                    }
                } else {
                    cnt[i] = cnt[i - 1];
                }
            }
            return cnt[str.length - 1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum(12258));
    }
}
