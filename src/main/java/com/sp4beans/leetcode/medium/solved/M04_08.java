package com.sp4beans.leetcode.medium.solved;

/**
 * @author wangjixin <wangjixin@kuaishou.com>
 * Created on 2020-04-18
 */
public class M04_08 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    private class Solution {
        TreeNode ans = null;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            recurseTree(root, p, q);
            return ans;
        }

        private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
            if (currentNode == null) {
                return false;
            }

            int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

            int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

            int mid = (currentNode == p || currentNode == q) ? 1 : 0;

            if (mid + left + right >= 2) {
                ans = currentNode;
            }

            return (mid + left + right > 0);
        }
    }
}
