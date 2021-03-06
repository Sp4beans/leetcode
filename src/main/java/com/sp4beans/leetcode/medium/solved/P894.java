package com.sp4beans.leetcode.medium.solved;

//        满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
//
//        返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
//
//        答案中每个树的每个结点都必须有 node.val=0。
//
//        你可以按任何顺序返回树的最终列表。
//
//         
//
//        示例：
//
//        输入：7
//        输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
//        解释：
//
//         
//
//        提示：
//
//        1 <= N <= 20

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P894 {
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
        Map<Integer, List<TreeNode>> memo = new HashMap();

        public List<TreeNode> allPossibleFBT(int N) {
            if (!memo.containsKey(N)) {
                List<TreeNode> ans = new LinkedList();
                if (N == 1) {
                    ans.add(new TreeNode(0));
                } else if (N % 2 == 1) {
                    for (int x = 0; x < N; ++x) {
                        int y = N - 1 - x;
                        for (TreeNode left : allPossibleFBT(x))
                            for (TreeNode right : allPossibleFBT(y)) {
                                TreeNode bns = new TreeNode(0);
                                bns.left = left;
                                bns.right = right;
                                ans.add(bns);
                            }
                    }
                }
                memo.put(N, ans);
            }

            return memo.get(N);
        }
    }
}
