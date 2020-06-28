package com.sp4beans.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

//        给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
//
//        按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//
//        "123"
//        "132"
//        "213"
//        "231"
//        "312"
//        "321"
//        给定 n 和 k，返回第 k 个排列。
//
//        说明：
//
//        给定 n 的范围是 [1, 9]。
//        给定 k 的范围是[1,  n!]。
//        示例 1:
//
//        输入: n = 3, k = 3
//        输出: "213"
//        示例 2:
//
//        输入: n = 4, k = 9
//        输出: "2314"

public class P60 {

    private class Solution {
        public String getPermutation(int n, int k) {
            int[] factorials = new int[n];
            List<Integer> nums = new ArrayList() {{add(1);}};

            factorials[0] = 1;
            for(int i = 1; i < n; ++i) {
                // generate factorial system bases 0!, 1!, ..., (n - 1)!
                factorials[i] = factorials[i - 1] * i;
                // generate nums 1, 2, ..., n
                nums.add(i + 1);
            }

            // fit k in the interval 0 ... (n! - 1)
            --k;

            // compute factorial representation of k
            StringBuilder sb = new StringBuilder();
            for (int i = n - 1; i > -1; --i) {
                int idx = k / factorials[i];
                k -= idx * factorials[i];

                sb.append(nums.get(idx));
                nums.remove(idx);
            }
            return sb.toString();
        }
    }

}
