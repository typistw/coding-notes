package com.data.structure.chapter6;

import org.junit.Assert;
import org.junit.Test;

/*
 * @author：jinsheng
 * @date：2020/08/10 23:16
 */
public class TestBinaryHeap {

    @Test
    public void testBinaryHeap(){
        BinaryHeap<Integer> heap = new BinaryHeap<>(4);
        heap.insert(3);
        heap.insert(8);
        heap.insert(9);
        heap.insert(2);
        heap.insert(5);

        Assert.assertEquals(2, (int)heap.findMin());
        Assert.assertFalse(heap.isEmpty());
        Assert.assertEquals(2, (int)heap.deleteMin());
        Assert.assertEquals(3, (int)heap.findMin());
        heap.makeEmpty();
        Assert.assertTrue(heap.isEmpty());


        Integer[] items = {8,9,5,3,2};
        heap = new BinaryHeap<>(items);
        Assert.assertEquals(2, (int)heap.findMin());
        Assert.assertFalse(heap.isEmpty());
        Assert.assertEquals(2, (int)heap.deleteMin());
        Assert.assertEquals(3, (int)heap.findMin());
        heap.makeEmpty();
        Assert.assertTrue(heap.isEmpty());

    }

}
