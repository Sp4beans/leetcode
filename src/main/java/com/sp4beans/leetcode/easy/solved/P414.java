package com.sp4beans.leetcode.easy.solved;

//        给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
//
//        示例 1:
//
//        输入: [3, 2, 1]
//
//        输出: 1
//
//        解释: 第三大的数是 1.
//        示例 2:
//
//        输入: [1, 2]
//
//        输出: 2
//
//        解释: 第三大的数不存在, 所以返回最大的数 2 .
//        示例 3:
//
//        输入: [2, 2, 3, 1]
//
//        输出: 1
//
//        解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
//        存在两个值为2的数，它们都排第二。

public class P414 {
    private static class Solution {
        public int thirdMax(int[] nums) {
            Integer m1 = null;
            Integer m2 = null;
            Integer m3 = null;

            for (int num : nums) {
                if (null == m1) {
                    m1 = num;
                } else {
                    if (num > m1) {
                        m3 = m2;
                        m2 = m1;
                        m1 = num;
                    } else if ((null == m2 || num > m2.intValue()) && num != m1.intValue()) {
                        m3 = m2;
                        m2 = num;
                    } else if ((null == m3 || num > m3.intValue()) && num != m1.intValue() && num != m2.intValue()) {
                        m3 = num;
                    }
                }
//                System.out.println(m1 + " " + m2 + " " + m3);
            }

            return null == m3 ? m1 : m3;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.thirdMax(new int[]{3, 2, 1}));
        System.out.println(solution.thirdMax(new int[]{1, 2}));
        System.out.println(solution.thirdMax(new int[]{2, 2, 3, 1}));
    }
}
