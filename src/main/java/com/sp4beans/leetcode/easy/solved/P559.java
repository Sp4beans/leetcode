package com.sp4beans.leetcode.easy.solved;

//        给定一个 N 叉树，找到其最大深度。
//
//        最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
//
//        例如，给定一个 3叉树 :
//
//         
//
//
//
//         
//
//        我们应返回其最大深度，3。
//
//        说明:
//
//        树的深度不会超过 1000。
//        树的节点总不会超过 5000。

import java.util.List;

public class P559 {
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private class Solution {
        public int maxDepth(Node root) {
            if (null == root) {
                return 0;
            }
            if (null == root.children || root.children.size() == 0) {
                return 1;
            }

            int max = -1;
            for (int i = 0; i < root.children.size(); i++) {
                max = Math.max(max, maxDepth(root.children.get(i)));
            }
            return max + 1;
        }
    }

}
