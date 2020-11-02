package com.leetcode.medium;

import com.leetcode.base.ListNode;

/**
 * Sort a linked list using insertion sort.
 *
 *
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 *
 *
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class InsertionSortList {

    public static void main(String[] args) {
        int[] num = {4,2,1,3}, num2 = {-1,5,3,4,0};
        ListNode node = insertionSortList(ListNode.initListNode(num));
        ListNode node2 = insertionSortList(ListNode.initListNode(num2));
        ListNode.printNode(node);
        ListNode.printNode(node2);
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;

        ListNode newHead = new ListNode(head.val);
        head =  head.next;
        while (head != null){
            sortListNode(newHead, head.val);
            head = head.next;
        }

        return newHead;
    }

    private static void sortListNode (ListNode head, int val){
        if(head.val >= val){
            ListNode temp = new ListNode(head.val);
            temp.next = head.next;
            head.next = temp;
            head.val = val;
        }else{
            if(head.next == null){
                head.next = new ListNode(val);
            }else{
                sortListNode(head.next, val);
            }
        }
    }

}
