package com.leetcode.easy;

import com.leetcode.base.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 *
 *
 * Example 1:
 *  1 -> 0 -> 1
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 * Example 3:
 *
 * Input: head = [1]
 * Output: 1
 * Example 4:
 *
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * Example 5:
 *
 * Input: head = [0,0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {
        int[] num = {1, 0,1}, num2 = {1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
        ListNode node = ListNode.initListNode(num);
        ListNode node2 = ListNode.initListNode(num2);
        System.out.println(getDecimalValue(node));
        System.out.println(getDecimalValue(node2));
    }

    public static int getDecimalValue(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        int size = list.size() - 1;
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == 1){
                sum += Math.pow(2, size - i);
            }
        }
        return sum;
    }
}
