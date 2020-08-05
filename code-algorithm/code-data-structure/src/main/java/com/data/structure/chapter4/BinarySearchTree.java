package com.data.structure.chapter4;

import java.nio.BufferUnderflowException;
import java.util.Comparator;

/*
 * 二叉查找树： 对于树中每个节点X，它的左子树中所有项的值都小于X中的项
 *  而右子树中所有项的值都大于X中的项
 * @author：jinsheng
 * @date：2020/07/18 15:36
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    private static class BinaryNode<T>{
        BinaryNode(T element){
            this(element, null, null);
        }

        BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right){
            this.element = element;
            this.left = left;
            this.right = right;
        }

        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;
    }

    private BinaryNode<T> root;
    private Comparator<? super T> cmp;

    public BinarySearchTree(){
        root = null;
    }

    public BinarySearchTree(Comparator<? super T> c){
        root = null;
        cmp = c;
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return  root == null;
    }

    public boolean contains(T val){
        return  contains(val, root);
    }

    public T findMin(){
        if(isEmpty())
            throw new BufferUnderflowException();
        return this.findMin(root).element;
    }

    public T findMax(){
        if(isEmpty())
            throw  new BufferUnderflowException();
        return this.findMax(root).element;
    }

    public void insert(T val){
        root = inset(val, root);
    }

    public void remove(T val){
        root = remove(val, root);
    }

    public void printTree(){
        if(isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

   public int height(){
        if(isEmpty())
            return  -1;
        else
            return height(root);
   }

    private boolean contains(T val, BinaryNode<T> node){
        if(node == null)
            return  false;

        int compareResult = myCompare(val,node.element);

        if(compareResult < 0)
            return contains(val, node.left);
        else if(compareResult > 0)
            return contains(val, node.right);
        else
            return true;
    }

    private int myCompare(T lhs, T rhs){
        if(cmp != null){
            return cmp.compare(lhs, rhs);
        }else{
            return lhs.compareTo(rhs);
        }
    }

    /**
     *  递归方法
     * @param node
     * @return
     */
    private BinaryNode<T> findMin(BinaryNode<T> node){
        if(node == null)
            return null;
        else if(node.left == null)
            return  node;

        return findMin(node.left);
    }

    /**
     * 循环遍历
     * @param node
     * @return
     */
    private BinaryNode<T> findMax(BinaryNode<T> node){
        if (node != null){
            while (node.right != null)
                node = node.right;
        }
        return node;
    }

    private BinaryNode<T> inset(T val, BinaryNode<T> node){
        if(node == null){
            // 基准情形
            return new BinaryNode<>(val, null, null);
        }

        int compareResult = myCompare(val, node.element);
        if(compareResult < 0)
            node.left = inset(val, node.left);
        else if(compareResult > 0)
            node.right = inset(val, node.right);
        else
            ; // duplicate, do nothing
        return node;
    }

    private BinaryNode<T> remove(T val, BinaryNode<T> node){
        if(node == null)
            return node;

        int compareResult = myCompare(val, node.element);
        if(compareResult < 0){
            node.left = remove(val, node.left);
        }else if (compareResult > 0){
            node.right = remove(val, node.right);
        }else if (node.left != null && node.right != null){
            // 用右子树最小节点替代
            node.element = findMax(node.right).element;
            // 删除右子树最小节点
            node.right = remove(node.element, node.right);

        }else{
            node = (node.left != null) ? node.left : node.right;
        }

        return  node;
    }

    /**
     * 中序遍历
     * @param node
     */
    private void printTree(BinaryNode<T> node){
        if(null != node){
            printTree(node.left);
            System.out.println(node.element);
            printTree(node.right);
        }
    }

    /**
     * 后序遍历 计算树的高度
     * @param node
     * @return
     */
    private int height(BinaryNode<T> node){
        if(null == node)
            return  -1;
        else
            return 1 + Math.max(height(node.left) , height(node.right));
    }
}
