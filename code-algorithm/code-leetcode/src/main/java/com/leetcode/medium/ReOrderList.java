package com.leetcode.medium;

import com.leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ReOrderList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        for(int i = 2; i <=5; i++){
            insetListNode(root, new ListNode(i));
        }

        reorderList(root);

        printListNode(root);
    }

    public  static void reorderList(ListNode head) {
        if(head == null)
            return ;

        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }

        int low = 0, height = list.size() - 1;
        while (low < height){
            if(head == null){
                head = resetNodeNext(list.get(low ++));
            }else{
                insetListNode(head, resetNodeNext(list.get(low ++ )));
            }

            insetListNode(head, resetNodeNext(list.get(height --)));
        }

        if(low == height){
            insetListNode(head, resetNodeNext(list.get(low)));
        }
    }

    private static void insetListNode(ListNode head, ListNode newNode){
        if(head == null){
            return;
        }

        if(head.next == null){
            head.next = newNode;
            return;
        }

        insetListNode(head.next, newNode);
    }

    private static ListNode resetNodeNext(ListNode node){
        node.next = null;
        return node;
    }

    private static  void printListNode(ListNode node){
        if(node == null)
            return;
        System.out.println(node.val);
        printListNode(node.next);
    }

}
