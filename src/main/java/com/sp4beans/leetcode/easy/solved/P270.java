package com.sp4beans.leetcode.easy.solved;

//	给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
//
//	注意：
//
//	给定的目标值 target 是一个浮点数
//	题目保证在该二叉搜索树中只会存在一个最接近目标值的数
//	示例：
//
//	输入: root = [4,2,5,1,3]，目标值 target = 3.714286
//
//	     4
//	    / \
//	   2   5
//	  / \
//	 1   3
//
//	输出: 4

public class P270 {

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
	 * right; TreeNode(int x) { val = x; } }
	 */

	private class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static class Solution {

		public int closestValue(TreeNode root, double target) {

			double curVal = Math.abs(target - root.val);

			if (null != root.left && target < root.val) {
				int left = closestValue(root.left, target);
				return Math.abs(left - target) < curVal ? left : root.val;
			}

			if (null != root.right && target > root.val) {
				int right = closestValue(root.right, target);
				return Math.abs(right - target) < curVal ? right : root.val;
			}

			return root.val;
		}
	}

}
