package com.sp4beans.leetcode.easy.solved;

//        对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
//
//        给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
//
//         
//
//        示例 1：
//
//        输入：A = [1,2,0,0], K = 34
//        输出：[1,2,3,4]
//        解释：1200 + 34 = 1234
//        解释 2：
//
//        输入：A = [2,7,4], K = 181
//        输出：[4,5,5]
//        解释：274 + 181 = 455
//        示例 3：
//
//        输入：A = [2,1,5], K = 806
//        输出：[1,0,2,1]
//        解释：215 + 806 = 1021
//        示例 4：
//
//        输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
//        输出：[1,0,0,0,0,0,0,0,0,0,0]
//        解释：9999999999 + 1 = 10000000000
//         
//
//        提示：
//
//        1 <= A.length <= 10000
//        0 <= A[i] <= 9
//        0 <= K <= 10000
//        如果 A.length > 1，那么 A[0] != 0

import java.util.LinkedList;
import java.util.List;

public class P989 {
    private class Solution {
        public List<Integer> addToArrayForm(int[] A, int K) {
            int index = A.length - 1;
            A[index] += K;

            int temp = 0;

            for (int i = A.length - 1; i >= 0; i--) {
                if (i == 0) {
                    temp = A[i] / 10;
                    A[i] = A[i] % 10;
                } else if (A[i] >= 10) {
                    A[i - 1] += A[i] / 10;
                    A[i] = A[i] % 10;
                }
            }

            LinkedList<Integer> result = new LinkedList<>();

            while (temp > 0) {
                result.addFirst(temp % 10);
                temp /= 10;
            }

            for (int num : A) {
                result.add(num);
            }
            return result;
        }
    }
}
