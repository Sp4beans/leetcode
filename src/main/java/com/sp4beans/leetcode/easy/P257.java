package com.sp4beans.leetcode.easy;

//        给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
//        说明: 叶子节点是指没有子节点的节点。
//
//        示例:
//
//        输入:
//
//        1
//        /   \
//        2     3
//        \
//        5
//
//        输出: ["1->2->5", "1->3"]
//
//        解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

import java.util.ArrayList;
import java.util.List;

public class P257 {

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
        private List<String> result = new ArrayList<>();

        private class Item {
            TreeNode treeNode;
            String path;

            Item(TreeNode treeNode, String path) {
                this.treeNode = treeNode;
                this.path = path;
            }
        }

        public List<String> binaryTreePaths(TreeNode root) {
            if (null != root)
                search(new Item(root, root.val + ""));

            return result;
        }

        public void search(Item item) {
            if (null == item || null == item.treeNode) {
                return;
            }

            if (null == item.treeNode.left && null == item.treeNode.right) {
                result.add(item.path);
            } else {
                if (null != item.treeNode.left) {
                    String newPath = item.path + "->" + item.treeNode.left.val;
                    search(new Item(item.treeNode.left, newPath));
                }
                if (null != item.treeNode.right) {
                    String newPath = item.path + "->" + item.treeNode.right.val;
                    search(new Item(item.treeNode.right, newPath));
                }
            }
        }
    }
}
