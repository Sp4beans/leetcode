package com.sp4beans.leetcode.easy;

//        给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
//
//        注意：请不要在超过该数组长度的位置写入元素。
//
//        要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
//
//         
//
//        示例 1：
//
//        输入：[1,0,2,3,0,4,5,0]
//        输出：null
//        解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
//        示例 2：
//
//        输入：[1,2,3]
//        输出：null
//        解释：调用函数后，输入的数组将被修改为：[1,2,3]
//         
//
//        提示：
//
//        1 <= arr.length <= 10000
//        0 <= arr[i] <= 9

public class P1089 {

    private static class Solution {
        public void duplicateZeros(int[] arr) {
            int count = 0;
            int i = 0;
            boolean endZeroFlag = false;
            boolean containsZero = false;
            for (i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    count += 2;
                    containsZero = true;
                } else {
                    count++;
                }
                if (count >= arr.length) {
                    endZeroFlag = count != arr.length;
                    break;
                }
            }

            if (!containsZero) {
                return;
            }

            int index = arr.length - 1;
            while (index >= 0 && i >= 0) {
                if (endZeroFlag) {
                    arr[index] = arr[i];
                    index--;
                    i--;
                    endZeroFlag = false;
                } else {
                    if (arr[i] == 0) {
                        arr[index] = 0;
                        arr[index - 1] = 0;
                        i--;
                        index -= 2;
                    } else {
                        arr[index] = arr[i];
                        index--;
                        i--;
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0, 0});
        solution.duplicateZeros(new int[]{1, 0, 2, 3, 0, 0, 5, 0, 0});
        solution.duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
        solution.duplicateZeros(new int[]{1, 0, 2, 3, 0, 0, 5, 0});
        solution.duplicateZeros(new int[]{8, 4, 5, 0, 0, 0, 0, 7});
    }
}
