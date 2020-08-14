package com.leetcode.easy;

/**
 *Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(3);

//        root.next.next = new ListNode(1);

        printNode(root);
        deleteDuplicates(root);
        printNode(root);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        if(head.val == head.next.val){
            head.next = head.next.next;
            deleteDuplicates(head);
        }else{
            deleteDuplicates(head.next);
        }
//        removeNode(node);

        return head;
    }

    public static void removeNode(ListNode node){
        if(node == null || node.next == null)
            return ;

        if(node.val == node.next.val){
            node.next = node.next.next;
            removeNode(node);
        }else{
            removeNode(node.next);
        }

    }

    private static void printNode(ListNode node){
        ListNode itemNode = node;
        StringBuilder sb = new StringBuilder();
        while (itemNode != null){
            sb.append(itemNode.val).append(",");
            itemNode = itemNode.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}



