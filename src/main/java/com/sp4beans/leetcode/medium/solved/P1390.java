package com.sp4beans.leetcode.medium.solved;

//        给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。
//
//        如果数组中不存在满足题意的整数，则返回 0 。
//
//         
//
//        示例：
//
//        输入：nums = [21,4,7]
//        输出：32
//        解释：
//        21 有 4 个因数：1, 3, 7, 21
//        4 有 3 个因数：1, 2, 4
//        7 有 2 个因数：1, 7
//        答案仅为 21 的所有因数的和。
//         
//
//        提示：
//
//        1 <= nums.length <= 10^4
//        1 <= nums[i] <= 10^5

import java.util.HashSet;
import java.util.Set;

public class P1390 {
    private static class Solution {
        public int sumFourDivisors(int[] nums) {
            int ans = 0;
            for (int n : nums) {
                ans += sumFourDivisors(n);
            }
            return ans;
        }

        public int sumFourDivisors(int n) {
            Set<Integer> set = new HashSet<>();
            set.add(1);
            set.add(n);
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    set.add(i);
                    set.add(n / i);
                    if (set.size() > 4) {
                        return 0;
                    }
                }
            }
            if (set.size() == 4) {
                int count = 0;
                for (Integer i : set) {
                    count += i;
                }
                return count;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sumFourDivisors(new int[] {1, 2, 3, 4, 5});
    }
}
