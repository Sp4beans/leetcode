package com.sp4beans.leetcode.easy.solved;

//        我们把符合下列属性的数组 A 称作山脉：
//
//        A.length >= 3
//        存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
//        给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
//
//         
//
//        示例 1：
//
//        输入：[0,1,0]
//        输出：1
//        示例 2：
//
//        输入：[0,2,1,0]
//        输出：1
//         
//
//        提示：
//
//        3 <= A.length <= 10000
//        0 <= A[i] <= 10^6
//        A 是如上定义的山脉

public class P852 {

    private static class Solution {
        public int peakIndexInMountainArray(int[] A) {
            int min = 0;
            int max = A.length - 1;
            while (max >= min) {
                int mid1 = (min + max) >> 1;
                int mid2 = (min + mid1) >> 1;
//                System.out.println(min + "-" + mid2 + "-" + mid1 + "-" + max);
                if (mid1 == mid2) {
                    if (mid1 == min || mid1 == max) {
                        return A[min] > A[max] ? min : max;
                    }
                }
                if (A[mid2] < A[mid1]) {
                    min = mid2 + 1;
                } else if (A[mid1] < A[mid2]) {
                    max = mid1 - 1;
                } else {
                    min = mid2 + 1;
                    max = mid1 - 1;
                }
            }
            return A[min] > A[max] ? min : max;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 1, 2, 0}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{13, 25, 38, 55, 58, 75, 85, 88, 100, 94, 88, 82, 60, 58, 48, 43, 40, 35, 17, 2}));
    }
}
