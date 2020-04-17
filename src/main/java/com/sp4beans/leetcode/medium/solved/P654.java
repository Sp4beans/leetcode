package com.sp4beans.leetcode.medium.solved;

//        给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
//
//        二叉树的根是数组中的最大元素。
//        左子树是通过数组中最大值左边部分构造出的最大二叉树。
//        右子树是通过数组中最大值右边部分构造出的最大二叉树。
//        通过给定的数组构建最大二叉树，并且输出这个树的根节点。
//
//         
//
//        示例 ：
//
//        输入：[3,2,1,6,0,5]
//        输出：返回下面这棵树的根节点：
//
//              6
//            /   \
//           3     5
//           \    /
//            2  0
//             \
//              1
//         
//
//        提示：
//
//        给定的数组的大小在 [1, 1000] 之间。

public class P654 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {

            return gen(nums, 0, nums.length - 1);
        }

        public TreeNode gen(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            if (start == end) {
                return new TreeNode(nums[start]);
            } else {
                int val = nums[start];
                int idx = start;
                for (int i = start + 1; i <= end; i++) {
                    if (nums[i] > val) {
                        val = nums[i];
                        idx = i;
                    }
                }
                TreeNode ans = new TreeNode(nums[idx]);
                ans.left = gen(nums, start, idx - 1);
                ans.right = gen(nums, idx + 1, end);
                return ans;
            }
        }
    }
}