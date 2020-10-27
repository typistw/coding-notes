package com.leetcode.medium;

import com.leetcode.base.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Notice that you should not modify the linked list.
 *
 * Follow up:
 *
 * Can you solve it using O(1) (i.e. constant) memory?
 *
 *
 *
 * Example 1:
 *  3->2->0->-4
 *     >
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * Example 2:
 *  1->2
 *  >
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * Example 3:
 * 1
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 *
 * Constraints:
 *
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode entry = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // there is a cycle
            if(slow == fast){
                // find the entry location
                while (slow != entry){
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }

        return null;
    }
}
