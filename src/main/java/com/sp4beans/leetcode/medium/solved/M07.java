package com.sp4beans.leetcode.medium.solved;

//        输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//         
//
//        例如，给出
//
//        前序遍历 preorder = [3,9,20,15,7]
//        中序遍历 inorder = [9,3,15,20,7]
//        返回如下的二叉树：
//
//            3
//           / \
//          9  20
//            /  \
//           15   7
//         
//
//        限制：
//
//        0 <= 节点个数 <= 5000
//
//         
//
//        注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

public class M07 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
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
        int[] pre;
        int[] in;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.pre = preorder;
            this.in = inorder;
            return genNode(0, pre.length-1, 0, in.length - 1);
        }

        public TreeNode genNode(int preStart, int preEnd, int inStart, int inEnd) {
            if (preStart > preEnd) {
                return null;
            }
            int curVal = pre[preStart];
            int i = inStart;
            for (; i <= inEnd; i++) {
                if (in[i] == curVal) {
                    break;
                }
            }

            int preLeftEnd = preStart + i + 1 - inStart;

            TreeNode node = new TreeNode(curVal);
            node.left = genNode(preStart + 1, preLeftEnd - 1, inStart, i - 1);
            node.right = genNode(preLeftEnd, preEnd, i + 1, inEnd);
            return node;
        }
    }
}
