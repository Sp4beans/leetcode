package com.sp4beans.leetcode.easy.solved;

//        实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
//
//        示例 1：
//
//        输入: s = "leetcode"
//        输出: false
//        示例 2：
//
//        输入: s = "abc"
//        输出: true
//        限制：
//
//        0 <= len(s) <= 100
//        如果你不使用额外的数据结构，会很加分。

import java.util.Arrays;

public class M01_01 {

    private class Solution {
        public boolean isUnique(String astr) {
            if (astr == null || astr.length() == 0) {
                return true;
            }
            char[] chars = astr.toCharArray();
            Arrays.sort(chars);
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == chars[i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }

}
