package com.sp4beans.leetcode.medium;

//        给你一个列表 nums ，里面每一个元素都是一个整数列表。请你依照下面各图的规则，按顺序返回 nums 中对角线上的整数。
//
//         
//
//        示例 1：
//        1  2  3
//        4  5  6
//        7  8  9
//
//        输入：nums = [[1,2,3],[4,5,6],[7,8,9]]
//        输出：[1,4,2,7,5,3,8,6,9]
//        示例 2：
//
//
//
//        输入：nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
//        输出：[1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
//        示例 3：
//
//        输入：nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
//        输出：[1,4,2,5,3,8,6,9,7,10,11]
//        示例 4：
//
//        输入：nums = [[1,2,3,4,5,6]]
//        输出：[1,2,3,4,5,6]
//         
//
//        提示：
//
//        1 <= nums.length <= 10^5
//        1 <= nums[i].length <= 10^5
//        1 <= nums[i][j] <= 10^9
//        nums 中最多有 10^5 个数字。

import java.util.List;

public class P1424 {
    private class Solution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            int min = 0;
            int max = 0;
            int size = 0;
            int idx = 0;
            for (int i = 0; i < nums.size(); i++) {
                max = Math.max(i + nums.get(i).size(), max);
                size += nums.get(i).size();
            }
            int[] index = new int[max];
            for (int i = 0; i < nums.size(); i++) {
                for (int j = 0; j < nums.get(i).size(); j++) {
                    index[i + j + 1]++;
                }
            }
            for (int i = 1; i < max; i++) {
                index[i] += index[i - 1];
            }

            int[] result = new int[size];
            for (int i = nums.size() - 1; i >= 0; i--) {
                for (int j = 0; j < nums.get(i).size(); j++) {
                    result[index[i + j]] = nums.get(j).get(i);
                    index[i + j]++;
                }
            }
            return result;
        }
    }
}
