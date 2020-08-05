package com.data.structure.chapter4;

/*
 *  AVL(Adelson-Velskii和Landis) 树是带有平衡条件的二叉查找树 (自平衡二叉查找树)
 *   最简单想法： 要求左右子树有相同高度
 *   特点： 每个节点的左子树和右子树的高度最多差 1 的二叉查找树(空树的高度定义为 -1 )
 * @author：jinsheng
 * @date：2020/07/19 16:13
 */
public class ValTree<T> {

    private static class AvlNode<T>{

        AvlNode(T element){
            this(element, null, null);
        }

        AvlNode(T element, AvlNode<T> lt, AvlNode<T> rt){
            this.element = element;
            this.left = lt;
            this.right = rt;
        }

        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;
    }

    private AvlNode<T> insert(T val, AvlNode<T> node){
        if(node == null)
            return  new AvlNode<>(val, null, null);

        return null;
    }

    private int height(AvlNode<T> node){
        return  node == null ? -1 : node.height;
    }
}
