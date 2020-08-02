package com.sp4beans.leetcode.medium.solved;

//        给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
//
//        进阶:
//        如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
//
//        示例:
//
//        // 初始化一个单链表 [1,2,3].
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        Solution solution = new Solution(head);
//
//        // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
//        solution.getRandom();

import java.util.Random;

public class P382 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
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

        /**
         * @param head The linked list's head.
         * Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        ListNode root;
        Random random = new Random();

        public Solution(ListNode head) {
           root = head;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            ListNode head = root;
            //因为返回一个值 所以 蓄水池 容量为1
            //蓄水池的水 就是 链表中的每个值.
            int[] res = {-1};
            int count = 0; //水的数量
            boolean isFull = false; //蓄水池是否已满
            while(head!=null){
                count++;  //数量加1;
                if(!isFull){
                    res[0] = head.val;
                    isFull = true; //将蓄水池 灌满  设置isFull为true;
                } else{
                    //蓄水池代码的模板，直接套用。
                    int i = random.nextInt(count);
                    if(i<1) res[0] = head.val;
                }
                head = head.next;

            }
            return res[0];
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(head);
     * int param_1 = obj.getRandom();
     */
}
