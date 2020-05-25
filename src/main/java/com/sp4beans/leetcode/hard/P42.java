package com.sp4beans.leetcode.hard;

//        给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
//        上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
//
//        示例:
//
//        输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//        输出: 6

public class P42 {
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
