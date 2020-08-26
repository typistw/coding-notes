package com.leetcode.medium;

import com.leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 *Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3,4,5};
        ListNode node = ListNode.initListNode(nums);
        ListNode.printNode(swapPairs(node));
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null)
            return head;

        List<ListNode> list = new ArrayList<>();
        traversalListNode(head, list);
        for(int i = 0; i < list.size() - 1;i += 2){
            ListNode firstNode = list.get(i);
            ListNode nextNode = list.get(i + 1);
            firstNode.next = nextNode.next;
            nextNode.next = firstNode;

            if(i != 0){
                ListNode beforeNode = list.get(i - 1);
                beforeNode.next = nextNode;
            }

            list.set(i, nextNode);
            list.set(i + 1, firstNode);
        }
        return list.get(0);
    }

    private static void traversalListNode(ListNode node, List<ListNode> list){
        if(node == null)
            return;

        list.add(node);
        traversalListNode(node.next, list);
    }
}
