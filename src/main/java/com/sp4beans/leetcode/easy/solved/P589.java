package com.sp4beans.leetcode.easy.solved;

//        给定一个 N 叉树，返回其节点值的前序遍历。
//
//        例如，给定一个 3叉树 :
//                          1
//                  3       2       4
//              5       6
//
//
//
//
//        返回其前序遍历: [1,3,5,6,2,4]。

import java.util.ArrayList;
import java.util.List;

public class P589 {
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
        public List<Integer> preorder(Node root) {
            List<Integer> result = new ArrayList<>();
            if (null == root) {
                return result;
            }
            result.add(root.val);
            List<Node> children = root.children;
            if (null != children && children.size() > 0) {
                for (Node node : children) {
                    result.addAll(preorder(node));
                }
            }
            return result;
        }
    }
}
