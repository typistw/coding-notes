package com.leetcode.easy;

import com.leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        int[] nums = {129, 129};
        ListNode root = ListNode.initListNode(nums);
        System.out.println(isPalindrome(root));
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> list  = new ArrayList<>();
        traversalList(head,list);
        for(int i = 0, j = list.size() - 1; i < j; i++, j--){
            if(!list.get(i).equals(list.get(j)) ){
                return false;
            }
        }
        return true;
    }

    private static void traversalList(ListNode node, List<Integer> list){
        if(node == null)
            return ;

        list.add(node.val);
        traversalList(node.next, list);
    }

}
