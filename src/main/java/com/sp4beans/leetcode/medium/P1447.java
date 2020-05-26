package com.sp4beans.leetcode.medium;

//        给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
//
//         
//
//        示例 1：
//
//        输入：n = 2
//        输出：["1/2"]
//        解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
//        示例 2：
//
//        输入：n = 3
//        输出：["1/2","1/3","2/3"]
//        示例 3：
//
//        输入：n = 4
//        输出：["1/2","1/3","1/4","2/3","3/4"]
//        解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
//        示例 4：
//
//        输入：n = 1
//        输出：[]
//         
//
//        提示：
//
//        1 <= n <= 100

import java.util.ArrayList;
import java.util.List;

public class P1447 {
    private class Solution {
        public List<String> simplifiedFractions(int n) {
            List<String> ans = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                ans.addAll(getList(i));
            }
            return ans;
        }

        public List<String> getList(int n) {
            List<String> ans = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                if (isValid(i, n)) {
                    ans.add(i + "/" + n);
                }
            }
            return ans;
        }

        public boolean isValid(int a, int b) {
            for (int i = 2; i <= Math.min(a, b); i++) {
                if (a % i == 0 && b % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
