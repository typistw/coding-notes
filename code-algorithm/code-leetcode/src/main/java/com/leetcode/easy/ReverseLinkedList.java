package com.leetcode.easy;

import com.leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author：jinsheng
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] nums = {1, 2,3,4,5};
        int[] nums2 = {1, 2,3,4,5};
//        ListNode head = ListNode.initListNode(nums);
//        ListNode head2 = ListNode.initListNode(nums2);
//        ListNode retNode = reverseListByIteratively(head);
//        ListNode retNode2 = reverseListByRecursively(head2);
//        ListNode.printNode(retNode);
//        ListNode.printNode(retNode2);

        int[] nums3  = {1,2,3,4,5};
        ListNode head3 = ListNode.initListNode(nums3);
        ListNode retNode = reverseList(head3);
        ListNode.printNode(retNode);
    }


    public static ListNode reverseList(ListNode head) {
        if(head == null)
            return null;

        ListNode reverseHead = null, preNode = null, node = head;
        while (node != null){
            ListNode next = node.next;
            if(next == null){
                reverseHead = node;
            }

            node.next = preNode;
            preNode = node;
            node = next;
        }

        return reverseHead;
    }

    public static ListNode reverseListByIteratively(ListNode head) {
        if(head == null)
            return  null;

        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.add(head);
            head = head.next;
        }

        ListNode node = stack.pop();
        while (!stack.isEmpty()){
            ListNode tempNode = stack.pop();
            tempNode.next = null;
            setNode(node, tempNode);
        }

        return node;
    }

    public static ListNode reverseListByRecursively(ListNode head) {
        if(head == null)
            return null;

        List<ListNode> list = new ArrayList<>();
        recursively(head, list);
        ListNode node = list.get(list.size()  - 1);
        for(int i =list.size() - 2; i >=0; i--){
            ListNode tempNode = list.get(i);
            tempNode.next = null;
            setNode(node, tempNode);
        }
        return node;
    }

    private static void recursively(ListNode head, List<ListNode> list) {
        if(head == null)
            return ;

        list.add(head);
        recursively(head.next, list);
    }

    private static void setNode(ListNode head, ListNode next){
        if(head.next == null){
            head.next = next;
        }else{
            setNode(head.next, next);
        }
    }

}
