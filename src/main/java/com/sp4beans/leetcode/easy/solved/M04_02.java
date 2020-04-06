package com.sp4beans.leetcode.easy.solved;

//        给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
//
//        示例:
//        给定有序数组: [-10,-3,0,5,9],
//
//        一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//                0
//               / \
//             -3   9
//             /   /
//           -10  5

public class M04_02 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            int start = 0;
            int end = nums.length - 1;
            return buildBST(nums, start, end);
        }

        public TreeNode buildBST(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }

            int mid = (start + end) >> 1;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildBST(nums, start, mid - 1);
            root.right = buildBST(nums, mid + 1, end);
            return root;
        }
    }
}
