package com.sp4beans.leetcode.hard;

//        给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
//
//
//
//        上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
//
//        示例:
//
//        输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//        输出: 6

public class M17_21 {
    private class Solution {
        public int trap(int[] height) {
            int length = height.length;
            int[] leftMax = new int[length];
            int[] rightMax = new int[length];
            int base = 0;
            int base2 = 0;
            for (int i = 0; i < length; i++) {
                leftMax[i] = Math.max(base, height[i]);
                base = leftMax[i];
                rightMax[length - 1 - i] = Math.max(base2, height[length - 1 - i]);
                base2 = rightMax[length - 1 - i];
            }

            int ans = 0;
            for (int i = 0; i < length; i++) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return ans;
        }
    }
}
