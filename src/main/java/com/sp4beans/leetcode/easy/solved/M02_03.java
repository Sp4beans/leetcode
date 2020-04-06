package com.sp4beans.leetcode.easy.solved;

//        实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。
//
//         
//
//        示例：
//
//        输入：单向链表a->b->c->d->e->f中的节点c
//        结果：不返回任何数据，但该链表变为a->b->d->e->f

public class M02_03 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public void deleteNode(ListNode node) {
            if (node == null) {
                return;
            }
            ListNode cur = node;
            while (cur.next != null && cur.next.next != null) {
                cur.val = cur.next.val;
                cur = cur.next;
            }
            cur.val = cur.next.val;
            cur.next = null;
        }
    }
}
