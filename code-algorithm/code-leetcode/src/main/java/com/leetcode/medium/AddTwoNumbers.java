package com.leetcode.medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        l1 = new ListNode(0);
        l2 = new ListNode(7);
        l2.next = new ListNode(3);

        printNode(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        addNumber(l1, l2, node);
        return  node;
    }

    public static void addNumber(ListNode l1, ListNode l2, ListNode sumNode){
        int val = sumNode.val;
        if(l1 != null){
            val += l1.val;
        }

        if(l2 != null){
            val += l2.val;
        }

        int nodeInitVal = 0;
        if(val >= 10){
            val = val%10;
            nodeInitVal = 1;

            sumNode.next = new ListNode(nodeInitVal);
        }
        sumNode.val = val;

        if((l1 != null && l1.next != null) &&  (l2 != null && l2.next != null)){
            if(sumNode.next == null){
                sumNode.next = new ListNode(nodeInitVal);
            }
            addNumber(l1.next, l2.next, sumNode.next);
        }

        if((l1 != null && l1.next != null) && (l2 == null || l2.next == null)){
            if(sumNode.next == null){
                sumNode.next = new ListNode(nodeInitVal);
            }
            addNumber(l1.next, null, sumNode.next);
        }

        if((l1 == null || l1.next == null) && (l2 != null && l2.next != null)){
            if(sumNode.next == null){
                sumNode.next = new ListNode(nodeInitVal);
            }
            addNumber(null, l2.next, sumNode.next);
        }

    }

    public static void printNode(ListNode node){
        if(node != null){
            System.out.println(node.val);
            if(node.next != null){
                printNode(node.next);
            }
        }

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}



