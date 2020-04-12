package com.sp4beans.leetcode.medium.solved;

//        给你一棵二叉树，请你返回层数最深的叶子节点的和。
//
//         
//
//        示例：
//
//
//
//        输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//        输出：15
//         
//
//        提示：
//
//        树中节点数目在 1 到 10^4 之间。
//        每个节点的值在 1 到 100 之间。

import java.util.ArrayList;
import java.util.List;

public class P1302 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class Solution {
        public int deepestLeavesSum(TreeNode root) {
            List<TreeNode> layer = new ArrayList<>();
            layer.add(root);
            int ans = 0;

            while (layer.size() > 0) {
                ans = 0;
                for (TreeNode node : layer) {
                    if (node != null) {
                        ans += node.val;
                    }
                }

                List<TreeNode> newLayer = new ArrayList<>();
                for (TreeNode node : layer) {
                    if (node != null) {
                        if (node.left != null) newLayer.add(node.left);
                        if (node.right != null) newLayer.add(node.right);
                    }
                }
                layer = newLayer;
            }

            return ans;
        }
    }

}
