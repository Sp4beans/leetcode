package com.sp4beans.leetcode.medium.solved;

//对链      表进行插入排序。
//
//
//        插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
//        每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
//
//         
//
//        插入排序算法：
//
//        插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
//        每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
//        重复直到所有输入数据插入完为止。
//         
//
//        示例 1：
//
//        输入: 4->2->1->3
//        输出: 1->2->3->4
//        示例 2：
//
//        输入: -1->5->3->4->0
//        输出: -1->0->3->4->5

public class P147 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public ListNode insertionSortList(ListNode head) {
            ListNode fake = new ListNode(-1);
            fake.next = head;
            ListNode end = head;
            while (end != null && end.next != null) {
                ListNode cur = end.next;
                //                System.out.println(cur.val);
                end.next = end.next.next;
                ListNode insert = fake;
                while (insert != end) {
                    if (insert.next.val >= cur.val) {
                        break;
                    }
                    insert = insert.next;
                }
//                System.out.println(insert.val);
                if (insert == end) {
                    end = cur;
                }
                cur.next = insert.next;
                insert.next = cur;
            }
            return fake.next;
        }
    }

    public static void main(String[] args) {
        //        [-1,5,3,4,0]
        ListNode head = new ListNode(-1);
        ListNode b = new ListNode(5);
        head.next = b;
        ListNode c = new ListNode(3);
        b.next = c;
        ListNode d = new ListNode(4);
        c.next = d;
        ListNode e = new ListNode(0);
        d.next = e;
        Solution solution = new Solution();
        ListNode result = solution.insertionSortList(head);

        System.out.println("--------");
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
