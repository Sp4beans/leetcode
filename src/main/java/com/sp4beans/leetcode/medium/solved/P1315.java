package com.sp4beans.leetcode.medium.solved;

//        给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
//
//        该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
//        如果不存在祖父节点值为偶数的节点，那么返回 0 。
//
//         
//
//        示例：
//
//
//
//        输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//        输出：18
//        解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
//         
//
//        提示：
//
//        树中节点的数目在 1 到 10^4 之间。
//        每个节点的值在 1 到 100 之间。

import java.util.Stack;

public class P1315 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class Solution {
        public int sumEvenGrandparent(TreeNode root) {
            int ans = 0;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                if (cur.left != null) {
                    stack.push(cur.left);
                    if (cur.val % 2 == 0) {
                        if (cur.left.left != null) {
                            ans += cur.left.left.val;
                        }
                        if (cur.left.right != null) {
                            ans += cur.left.right.val;
                        }
                    }
                }

                if (cur.right != null) {
                    stack.push(cur.right);
                    if (cur.val % 2 == 0) {
                        if (cur.right.left != null) {
                            ans += cur.right.left.val;
                        }
                        if (cur.right.right != null) {
                            ans += cur.right.right.val;
                        }
                    }
                }
            }

            return ans;
        }
    }
}
