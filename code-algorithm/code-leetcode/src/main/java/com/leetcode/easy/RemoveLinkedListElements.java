package com.leetcode.easy;

import com.leetcode.base.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode node  = ListNode.initListNode(nums);
//        ListNode retNode = removeElements(node, 6);
        ListNode retNode = removeElementsByIteration(node, 6);
        ListNode.printNode(retNode);
    }

    public static  ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static ListNode removeElementsByIteration(ListNode head, int val){
        ListNode tempNode = new ListNode(-1);
        tempNode.next = head;
        ListNode curr = tempNode;
        while (curr.next != null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return  tempNode.next;
    }
}
