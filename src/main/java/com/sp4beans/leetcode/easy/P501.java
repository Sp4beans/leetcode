package com.sp4beans.leetcode.easy;

//        给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//
//        假定 BST 有如下定义：
//
//        结点左子树中所含结点的值小于等于当前结点的值
//        结点右子树中所含结点的值大于等于当前结点的值
//        左子树和右子树都是二叉搜索树
//        例如：
//        给定 BST [1,null,2,2],
//
//        1
//        \
//        2
//        /
//        2
//        返回[2].
//
//        提示：如果众数超过1个，不需考虑输出顺序
//
//        进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）

import java.util.ArrayList;
import java.util.List;

public class P501 {
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

        List<Integer> ans = new ArrayList<>();
        int maxCount = 0;
        TreeNode pre = null;
        int cur = 1;

        public int[] findMode(TreeNode root) {
            if (null == root) {
                return new int[]{};
            }
            preOrder(root);

            int[] result = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                result[i] = ans.get(i);
            }
            return result;
        }

        public void preOrder(TreeNode root) {
            if (null == root) {
                return;
            }
            preOrder(root.left);
            if (null != pre) {
                if (pre.val == root.val) {
                    cur++;
                } else {
                    cur = 1;
                }
            }
            if (cur == maxCount) {
                ans.add(root.val);
            } else if (cur > maxCount) {
                ans.clear();
                ans.add(root.val);
                maxCount = cur;
            }
            pre = root;
            preOrder(root.right);
        }
    }
}
