package com.sp4beans.leetcode.easy.solved;

//        给定已经按升序排列、由不同整数组成的数组 A，返回满足 A[i] == i 的最小索引 i。如果不存在这样的 i，返回 -1。
//
//         
//
//        示例 1：
//
//        输入：[-10,-5,0,3,7]
//        输出：3
//        解释：
//        对于给定的数组，A[0] = -10，A[1] = -5，A[2] = 0，A[3] = 3，因此输出为 3 。
//        示例 2：
//
//        输入：[0,2,5,8,17]
//        输出：0
//        示例：
//        A[0] = 0，因此输出为 0 。
//        示例 3：
//
//        输入：[-10,-5,3,4,7,9]
//        输出：-1
//        解释：
//        不存在这样的 i 满足 A[i] = i，因此输出为 -1 。
//         
//
//        提示：
//
//        1 <= A.length < 10^4
//        -10^9 <= A[i] <= 10^9

public class P1064 {
    private static class Solution {
        public int fixedPoint(int[] A) {
            for (int i = 0; i < A.length; i++) {
                if (A[i] < 0) continue;
                if (A[i] == i) return i;
                if (A[i] > i) return -1;
            }
            return -1;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.fixedPoint(new int[]{-10, -5, 0, 3, 7}));
        System.out.println(solution.fixedPoint(new int[]{0, 2, 5, 8, 17}));
        System.out.println(solution.fixedPoint(new int[]{-10, -5, 3, 4, 7, 9}));
    }
}
