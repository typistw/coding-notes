package com.data.structure.chapter4;

import org.junit.Assert;
import org.junit.Test;

/*
 * @author：jinsheng
 * @date：2020/07/18 16:54
 */
public class TestBinarySearchTree {

    @Test
    public void testBinarySearchTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Assert.assertTrue(tree.isEmpty());

        tree.insert(6);
        tree.insert(3);
        tree.insert(1);
        tree.insert(8);
        tree.insert(2);
        tree.insert(5);
        tree.insert(4);

        Assert.assertFalse(tree.isEmpty());
        Assert.assertTrue(tree.contains(2));
        Assert.assertEquals(1,(int)tree.findMin());
        Assert.assertEquals(8,(int)tree.findMax());
        tree.remove(2);
        Assert.assertFalse(tree.contains(2));

        System.out.println("tree height:" + tree.height());
        tree.printTree();

        tree.makeEmpty();
        Assert.assertTrue(tree.isEmpty());
    }
}
