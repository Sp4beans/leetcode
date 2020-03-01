package com.sp4beans.leetcode.easy;

//        输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
//        示例 1：
//
//        输入：head = [1,3,2]
//        输出：[2,3,1]

public class M06 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private class Solution {
        int[] ans;
        int i = 0;
        public int[] reversePrint(ListNode head) {
            helper(0, head);
            return ans;
        }

        public void helper(int curIndex, ListNode head) {
            if (head == null) {
                ans = new int[curIndex];
            } else {
                helper(curIndex + 1, head.next);
                ans[i] = head.val;
                i++;
            }
        }
    }
}
