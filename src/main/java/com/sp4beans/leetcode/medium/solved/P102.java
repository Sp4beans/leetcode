package com.sp4beans.leetcode.medium.solved;

//        给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
//
//        例如:
//        给定二叉树: [3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回其层次遍历结果：
//
//        [
//        [3],
//        [9,20],
//        [15,7]
//        ]

import java.util.ArrayList;
import java.util.List;

public class P102 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            List<TreeNode> lastLayer = new ArrayList<>();
            if (root != null) {
                lastLayer.add(root);
            }

            int index = 0;
            while(index != lastLayer.size()) {
                List<Integer> layerValue = new ArrayList<>();
                int length = lastLayer.size();
                for(int i = index; i < length; i++) {
                    TreeNode node = lastLayer.get(i);
                    layerValue.add(node.val);
                    if (node.left != null) {
                        lastLayer.add(node.left);
                    }
                    if (node.right != null) {
                        lastLayer.add(node.right);
                    }
                }
                if (!layerValue.isEmpty()) {
                    result.add(layerValue);
                }
                index = length;
            }
            return result;
        }
    }
}
