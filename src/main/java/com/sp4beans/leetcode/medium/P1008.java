package com.sp4beans.leetcode.medium;

//        返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
//
//        (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，先序遍历首先显示节点的值，然后遍历 node.left，接着遍历 node.right。）
//
//         
//
//        示例：
//
//        输入：[8,5,1,7,10,12]
//        输出：[8,5,10,1,7,null,12]
//
//         
//
//        提示：
//
//        1 <= preorder.length <= 100
//        先序 preorder 中的值是不同的。

public class P1008 {
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
        public TreeNode bstFromPreorder(int[] preorder) {
            TreeNode root = func(preorder, 0, preorder.length - 1);
            return root;
        }

        public TreeNode func(int[] preorder, int start, int end) {
            if (start > end) {
                return null;
            } else if (start == end) {
                return new TreeNode(preorder[start]);
            }
            TreeNode node = new TreeNode(preorder[start]);
            int cur = node.val;
            start++;
            int it = start;
            while (it <= end) {
                if (preorder[it] < cur) {
                    it++;
                } else {
                    break;
                }
            }
            node.left = func(preorder, start, it - 1);
            node.right = func(preorder, it, end);

            return node;
        }
    }
}
