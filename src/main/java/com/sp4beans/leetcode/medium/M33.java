package com.sp4beans.leetcode.medium;

//        输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
//         
//
//        参考以下这颗二叉搜索树：
//
//        5
//        / \
//        2   6
//        / \
//        1   3
//        示例 1：
//
//        输入: [1,6,3,2,5]
//        输出: false
//        示例 2：
//
//        输入: [1,3,2,6,5]
//        输出: true
//         
//
//        提示：
//
//        数组长度 <= 1000

public class M33 {
    private static class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return isPostOrder(postorder, 0, postorder.length - 1);
        }

        public boolean isPostOrder(int[] postorder, int start, int end) {
            if (start >= end || end < 0) {
                return true;
            }
            int root = postorder[end];
            int mid = start;
            for (; mid < end; mid++) {
                if (postorder[mid] > root) {
                    break;
                }
            }
            for (int i = mid; i < end; i++) {
                if (postorder[i] < root) {
                    return false;
                }
            }

            return isPostOrder(postorder, start, mid - 1) && isPostOrder(postorder, mid, end - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.verifyPostorder(new int[]{5,4,3,2,1}));
    }
}
