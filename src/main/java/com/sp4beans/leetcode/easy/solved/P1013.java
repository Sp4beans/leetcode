package com.sp4beans.leetcode.easy.solved;

//        给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
//
//        形式上，如果我们可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
//
//         
//
//        示例 1：
//
//        输出：[0,2,1,-6,6,-7,9,1,2,0,1]
//        输出：true
//        解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
//        示例 2：
//
//        输入：[0,2,1,-6,6,7,9,-1,2,0,1]
//        输出：false
//        示例 3：
//
//        输入：[3,3,6,5,-2,2,5,1,-9,4]
//        输出：true
//        解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
//         
//
//        提示：
//
//        3 <= A.length <= 50000
//        -10000 <= A[i] <= 10000

public class P1013 {
    private static class Solution {
        public boolean canThreePartsEqualSum(int[] A) {

            int sum = 0;
            for (int a : A) {
                sum += a;
            }
            if (sum % 3 != 0) {
                return false;
            }

            int target = sum / 3;
            int zeroCount = 0;
            for (int a : A) {
                target = target - a;
                if (target == 0) {
                    target = sum / 3;
                    zeroCount++;
                    if (zeroCount == 2) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        System.out.println(solution.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
        System.out.println(solution.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
    }
}
