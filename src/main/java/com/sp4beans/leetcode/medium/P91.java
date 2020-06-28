package com.sp4beans.leetcode.medium;

//        一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
//        'A' -> 1
//        'B' -> 2
//        ...
//        'Z' -> 26
//        给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
//        示例 1:
//
//        输入: "12"
//        输出: 2
//        解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
//        示例 2:
//
//        输入: "226"
//        输出: 3
//        解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。


public class P91 {
    private static class Solution {
        public int numDecodings(String s) {
            char[] str = s.toCharArray();
            int[] cnt = new int[str.length];
            cnt[0] = 1;
            if (str[0] == '0') {
                return 0;
            }
            for (int i = 1; i < str.length; i++) {
                if (str[i] == '0') {
                    if (str[i - 1] != '1' && str[i - 1] != '2') {
                        return 0;
                    } else {
                        if (i >= 2 && (str[i - 2] == '1' || str[i - 2] == '2')) {
                            cnt[i] = cnt[i - 2];
                        } else {
                            cnt[i] = cnt[i - 1];
                        }
                    }
                    continue;
                }

                if (str[i - 1] == '1') {
                    cnt[i] = cnt[i - 1];
                    if (i >= 2) {
                        cnt[i] += cnt[i - 2];
                    } else {
                        cnt[i] += 1;
                    }
                } else if (str[i - 1] == '2') {
                    if (str[i] >= '0' && str[i] <= '6') {
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
        System.out.println(solution.numDecodings("10"));
        System.out.println(solution.numDecodings("110"));
        System.out.println(solution.numDecodings("12120"));
    }
}
