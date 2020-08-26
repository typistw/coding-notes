package com.leetcode.base;

/**
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ListNode {
    public int val;
    public ListNode next;

   public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

   public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode initListNode(int[] array){
       ListNode node = new ListNode(array[0]);
       for(int i = 1; i < array.length ; i++){
           setNodeNext(node, new ListNode(array[i]));
       }
       return node;
    }

    public static void printNode(ListNode node){
       StringBuilder sb = new StringBuilder();
       while (node != null){
           sb.append(node.val).append(",");
           node = node.next;
       }
        System.out.println(sb.toString());
    }

    private static void setNodeNext(ListNode head, ListNode nextNode){
        if(head == null){
            return;
        }

        if(head.next == null){
            head.next = nextNode;
            return;
        }

        setNodeNext(head.next, nextNode);
    }

}
