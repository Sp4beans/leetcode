package com.sp4beans.leetcode.medium.solved;

//        给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,
// n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
//
//        示例：
//
//        输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
//        输出： [3,9]
//        提示：
//
//        0 <= len(array) <= 1000000

import java.util.Arrays;

public class M16_16 {
    private static class Solution {
        public int[] subSort(int[] array) {
            int[] tmp = Arrays.copyOf(array, array.length);
            Arrays.sort(tmp);
            int startIdx = -1;
            int endIdx = -1;
            for (int i = 0; i < array.length; i++) {
                if (tmp[i] != array[i]) {
                    startIdx = i;
                    break;
                }
            }
            for (int i = array.length - 1; i >= 0; i--) {
                if (tmp[i] != array[i]) {
                    endIdx = i;
                    break;
                }
            }
            if (startIdx >= 0 && endIdx >= 0 && startIdx <= endIdx) {
                return new int[] {startIdx, endIdx};
            } else {
                return new int[] {-1, -1};
            }
        }
    }
}
