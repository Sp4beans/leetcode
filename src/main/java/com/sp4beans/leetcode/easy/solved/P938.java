package com.sp4beans.leetcode.easy.solved;

//        给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
//
//        二叉搜索树保证具有唯一的值。
//
//         
//
//        示例 1：
//
//        输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
//        输出：32
//        示例 2：
//
//        输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
//        输出：23
//         
//
//        提示：
//
//        树中的结点数量最多为 10000 个。
//        最终的答案保证小于 2^31。

import java.util.LinkedList;
import java.util.Queue;

public class P938 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public int rangeSumBST(TreeNode root, int L, int R) {
            int result = 0;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode target = queue.poll();
                if (null != target) {
                    boolean flag = false;
                    if (target.val >= L && target.val <= R) {
                        result += target.val;
                        queue.add(target.left);
                        queue.add(target.right);
                    } else if (target.val < L) {
                        queue.add(target.right);
                    } else if (target.val > R) {
                        queue.add(target.left);
                    }
                }
            }
            return result;
        }
    }
}
