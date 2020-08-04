package com.sp4beans.leetcode.medium;

//        给出一个含有不重复整数元素的数组，每个整数均大于 1。
//
//        我们用这些整数来构建二叉树，每个整数可以使用任意次数。
//
//        其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
//
//        满足条件的二叉树一共有多少个？返回的结果应模除 10 ** 9 + 7。
//
//         
//
//        示例 1:
//
//        输入: A = [2, 4]
//        输出: 3
//        解释: 我们可以得到这些二叉树: [2], [4], [4, 2, 2]
//        示例 2:
//
//        输入: A = [2, 4, 5, 10]
//        输出: 7
//        解释: 我们可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
//         
//
//        提示:
//
//        1 <= A.length <= 1000.
//        2 <= A[i] <= 10 ^ 9.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P823 {
    private class Solution {
        static final int MOD = 1000000007;

        public int numFactoredBinaryTrees(int[] A) {
            Arrays.sort(A);
            Map<Integer, Long> map = new HashMap<>();
            for (int a : A) {
                map.put(a, 1L);
            }
            for (int i = 0; i < A.length; i++) {
                long cur = map.get(A[i]);
                for (int j = 0; j < i; j++) {
                    int a = A[i] % A[j];
                    int b = A[i] / A[j];
                    if (a == 0 && map.containsKey(b)) {
                        cur = (cur + (map.get(A[j]) * map.get(b)) % MOD) % MOD;
                    }
                }
                map.put(A[i], cur);
            }

            map.forEach((k, v) -> {
                System.out.println("k = " + k + ", v = " + v);
            });

            int ans = 0;
            for (long v : map.values()) {
                ans = (int) ((ans + v) % MOD);
            }
            return ans;
        }
    }
}
