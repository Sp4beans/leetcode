package com.sp4beans.leetcode.medium;

//        从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
//
//         
//
//        例如:
//        给定二叉树: [3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回：
//
//        [3,9,20,15,7]
//         
//
//        提示：
//
//        节点总数 <= 1000

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class M32I {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }

            List<Integer> ans=  new ArrayList();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()) {
                TreeNode cur = queue.pollFirst();
                if (cur != null) {
                    ans.add(cur.val);
                }
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }

            int[] result = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                result[i] = ans.get(i);
            }

            return result;
        }
    }

}
