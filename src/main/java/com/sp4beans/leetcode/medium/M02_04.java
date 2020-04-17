package com.sp4beans.leetcode.medium;

//        编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
//        如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
//
//        示例:
//
//        输入: head = 3->5->8->5->10->2->1, x = 5
//        输出: 3->1->2->10->5->5->8

public class M02_04 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

//    [1,4,3,2,5,2]
//            3


//[2,2,1,4,3,5]

    private class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null) {
                return head;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy.next;
            ListNode cur = pre.next;
            while (cur != null) {
                if (cur.val < x) {
                    pre.next = cur.next;
                    cur.next = dummy.next;
                    dummy.next = cur;
                } else {
                    pre = pre.next;
                }
                cur = pre == null ? null : pre.next;
            }
            return dummy.next;
        }
    }
}
