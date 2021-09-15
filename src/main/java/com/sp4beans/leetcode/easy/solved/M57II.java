package com.sp4beans.leetcode.easy.solved;

//        输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//
//        序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//
//         
//
//        示例 1：
//
//        输入：target = 9
//        输出：[[2,3,4],[4,5]]
//        示例 2：
//
//        输入：target = 15
//        输出：[[1,2,3,4,5],[4,5,6],[7,8]]
//         
//
//        限制：
//
//        1 <= target <= 10^5

import java.util.ArrayList;
import java.util.List;

public class M57II {
    private class Solution {
        public int[][] findContinuousSequence(int target) {
            int length = target / 2 + 1;
            int[] ttmap = new int[length + 1];
            for (int i = 1; i <= length; i++) {
                ttmap[i] = i + ttmap[i-1];
            }

            List<Integer[]> ans = new ArrayList();
            int min = 1;
            int max = 1;
            while (min <= max && max <= target / 2 + 1) {
                int curAns = ttmap[max] - ttmap[min - 1];
                if (curAns < target) {
                    max++;
                } else if (curAns > target) {
                    min++;
                } else {
                    Integer[] aans = new Integer[max - min + 1];
                    for (int i = min; i <= max; i++) {
                        aans[i - min] = i;
                    }
                    ans.add(aans);
                    max++;
                    min++;
                }
            }
            int[][] newAns = new int[ans.size()][];
            int index = 0;
            for (Integer[] arr : ans) {
                int[] tmp = new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    tmp[i] = arr[i];
                }
                newAns[index++] = tmp;
            }
            return newAns;
        }
    }
}
