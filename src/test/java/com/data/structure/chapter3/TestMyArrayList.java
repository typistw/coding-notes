package com.data.structure.chapter3;

import org.junit.Test;

import java.util.Iterator;

/*
 * @author：jinsheng
 * @date：2020/03/22 22:02
 */
public class TestMyArrayList {

    @Test
    public void testMyArrayList(){
        MyArrayList<Integer> list = new MyArrayList<>();
        for(int i = 100; i > 86; i--){
            list.add(i);
        }
        System.out.println("插入数据后链表大小:" + list.size());
        System.out.println("遍历链表:");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        int removeItem = list.remove(10);
        System.out.println("删除数据:" + removeItem);

        int addVal = 999;
        System.out.println("增加数据:" + addVal );
        list.add(addVal);

        int modifyVal = -1;
        list.set(0,modifyVal);
        System.out.println("修改第一个元素为:" + modifyVal);
        System.out.println("获取第二个元素:" + list.get(1));

        System.out.println("遍历操作后的链表:");
         iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.println("清空链表前2数组大小:" + list.size());
        list.clear();
        System.out.println("清空链表后数组大小:" + list.size());

    }
}
