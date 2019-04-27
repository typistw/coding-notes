package com.leetcode;

/*
 * 描述：
 *      合并两个有序链表为一个新的有序链表
 *  example:
 *      input: 1->2->4, 1->->3->4
 *      output: 1->1->2->3->4->4
 *
 * @author：jinsheng
 * @date：2019/04/21 22:41
 */
public class MergeToSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode mergeNode = mergeTwoLists(l1, l2);
        while (null != mergeNode){
            System.out.println(mergeNode.val);
            mergeNode = mergeNode.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(null == l1)
            return l2;
        if(null == l2)
            return  l1;

        ListNode result = new ListNode(0);
        ListNode mergerNode = result;
        while (null != l1 && null != l2){
            if(l1.val <= l2.val){
                mergerNode.next = l1;
                l1 = l1.next;
            }else{
                mergerNode.next = l2;
                l2 = l2.next;
            }
            mergerNode = mergerNode.next;
        }

        if(null != l1)
            mergerNode.next =  l1;
       if(null != l2)
            mergerNode.next = l2;
        return  result.next;
    }

    private static ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2){
        if(null == l1)
            return l2;
        if(null == l2)
            return  l1;

        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return  l1;
        }else{
           l2.next = mergeTwoLists(l1, l2.next);
           return l2;
        }
    }

    public static  class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
