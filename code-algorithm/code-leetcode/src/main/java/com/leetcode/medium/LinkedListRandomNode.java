package com.leetcode.medium;

import com.leetcode.base.ListNode;

/**
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 *
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 *
 * Example:
 *
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class LinkedListRandomNode {

    private ListNode root;
    private int length = 0;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ListNode head = ListNode.initListNode(nums);
        LinkedListRandomNode randomNode = new LinkedListRandomNode(head);

        System.out.println(randomNode.getRandom());
        System.out.println(randomNode.getRandom());
        System.out.println(randomNode.getRandom());
        System.out.println(randomNode.getRandom());
        System.out.println(randomNode.getRandom());
    }

    public LinkedListRandomNode(ListNode head) {
        root = head;
        while (head != null){
            head = head.next;
            length ++;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode tempNode = root;
        int max = length  , min = 0;
        int random = (int) (Math.random() * (max - min) + min);
        int count = 0, retValue = 0;
        while (tempNode != null){
            if(count == random){
                retValue = tempNode.val;
                break;
            }
            count ++;
            tempNode = tempNode.next;
        }

        return retValue;
    }

}
