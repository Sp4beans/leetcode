package com.sp4beans.leetcode.easy.solved;

//        一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
//
//        注意：本题相对原题稍作改动
//
//         
//
//        示例 1：
//
//        输入： [1,2,3,1]
//        输出： 4
//        解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
//        示例 2：
//
//        输入： [2,7,9,3,1]
//        输出： 12
//        解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
//        示例 3：
//
//        输入： [2,1,4,5,3,1,1,3]
//        输出： 12
//        解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。

public class M17_16 {
    private class Solution {
        public int massage(int[] nums) {
            int max = 0;
            int[] sum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    sum[i] = nums[i];
                } else if (i == 1) {
                    sum[i] = Math.max(nums[i], sum[i-1]);
                } else {
                    sum[i] = Math.max(sum[i-1], nums[i] + sum[i-2]);
                }
                max = Math.max(max, sum[i]);
            }

            return max;
        }
    }
}
