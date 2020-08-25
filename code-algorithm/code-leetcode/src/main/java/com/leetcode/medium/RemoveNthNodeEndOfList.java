package com.leetcode.medium;

import com.leetcode.base.ListNode;

/**
 *Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class RemoveNthNodeEndOfList {

    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 4, 5};
        int[] array = {1, 2};
        ListNode node =   ListNode.initListNode(array);
        System.out.println(removeNthFromEnd(node, 2));
        System.out.println(getListLength(node));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;

        int listDeep = getListLength(head);
        if(listDeep == n){
            head = head.next;
            return head;
        }

        removeNode(head,  n);
        return head;
    }

    private static int removeNode(ListNode node , int m){
        if(node == null)
            return 0;
        int levelIndex = 1 + removeNode(node.next, m);

        if(levelIndex == m + 1){
            node.next = node.next.next;
            return levelIndex;
        }
        return  levelIndex;
    }

    private static int getListLength(ListNode node){
        if(node == null)
            return 0;
        return  1 + getListLength(node.next);
    }

}
