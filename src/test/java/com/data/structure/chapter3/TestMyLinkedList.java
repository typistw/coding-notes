package com.data.structure.chapter3;

import org.junit.Test;

import java.util.Iterator;

/*
 * @author：jinsheng
 * @date：2020/03/31 16:42
 */
public class TestMyLinkedList {

    @Test
    public void testLinkedList(){
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(45);
        System.out.println("获取头结点:" + linkedList.get(0));
        linkedList.add(2);
        linkedList.add(40);
        linkedList.add(99);

        int idx = 2;
        System.out.println("获取第" + idx +  "个节点" + linkedList.get(idx));
        System.out.println("遍历链表：");
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.println("删除第" + idx  + "个节点：" + linkedList.remove(idx));

        System.out.println("遍历链表(删除操作后)：");
        iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.println("链表是否为空(清除前)：" +  linkedList.isEmpty());
        linkedList.clean();
        System.out.println("链表是否为空(清除后)：" +  linkedList.isEmpty());
    }
}
