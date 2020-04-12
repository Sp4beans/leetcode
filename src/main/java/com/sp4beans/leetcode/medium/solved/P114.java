package com.sp4beans.leetcode.medium.solved;

/**
 * @author wangjixin <wangjixin@kuaishou.com>
 * Created on 2020-02-20
 */
public class P114 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public void flatten(TreeNode root) {
            TreeNode cur = root;
            while (cur != null) {
                if (cur.left != null) {
                    TreeNode curRigth = cur.right;
                    TreeNode curLeft = cur.left;
                    cur.left = null;
                    cur.right = curLeft;

                    while (curLeft != null && curLeft.right != null) {
                        curLeft = curLeft.right;
                    }
                    curLeft.right = curRigth;
                }
                cur = cur.right;
            }
        }
    }
}
