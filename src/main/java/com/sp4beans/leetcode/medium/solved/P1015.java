package com.sp4beans.leetcode.medium.solved;

//        给定正整数 K，你需要找出可以被 K 整除的、仅包含数字 1 的最小正整数 N。
//
//        返回 N 的长度。如果不存在这样的 N，就返回 -1。
//
//         
//
//        示例 1：
//
//        输入：1
//        输出：1
//        解释：最小的答案是 N = 1，其长度为 1。
//        示例 2：
//
//        输入：2
//        输出：-1
//        解释：不存在可被 2 整除的正整数 N 。
//        示例 3：
//
//        输入：3
//        输出：3
//        解释：最小的答案是 N = 111，其长度为 3。
//         
//
//        提示：
//
//        1 <= K <= 10^5

import java.util.HashSet;
import java.util.Set;

public class P1015 {
    private static class Solution {
        public int smallestRepunitDivByK(int K) {
            int count = 1;
            int cur = 1;
            Set<Integer> set = new HashSet<>();
            while (cur % K != 0) {
                int tmp = cur % K;
                if (set.contains(tmp)) {
                    return -1;
                } else {
                    set.add(tmp);
                }
                cur = tmp * 10 + 1;
                count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestRepunitDivByK(1));
        System.out.println(solution.smallestRepunitDivByK(2));
        System.out.println(solution.smallestRepunitDivByK(3));
    }
}
