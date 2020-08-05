package com.data.structure.chapter3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * 双向链表
 * @author：jinsheng
 * @date：2020/03/31 15:35
 */
public class MyLinkedList<T> implements Iterable<T> {

    private int theSize;
    private int modeCount;
    private Node<T> beginMarker;
    private Node<T> endMarker;


    public MyLinkedList() {
        clean();
    }

    public int size() {
        return theSize;
    }

    public void clean() {
        beginMarker = new Node<>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modeCount++;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public  boolean add(T x){
        add(size(), x);
        return true;
    }

    public void add(int idx, T x){
        addBefore(getNode(idx), x);
    }

    public T get(int idx){
        return getNode(idx).data;
    }

    public T set(int idx, T newVal){
        Node<T> p = getNode(idx);
        T oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public T remove(int idx){
        return remove(getNode(idx));
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private static class Node<T> {
        public T data;
        public Node<T> prev;
        public Node<T> next;

        public Node(T d, Node<T> p, Node<T> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    /**
     *  p 节点前添加 x节点
     * @param p
     * @param x
     */
    private void addBefore(Node<T> p, T x){
        Node<T> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize ++;
        modeCount ++;
    }

    /**
     * 获取索引位置的节点
     * @param idx
     * @return
     */
    private Node<T> getNode(int idx){
        Node<T> p;
        if(idx < 0 || idx > size()){
            throw  new IndexOutOfBoundsException();
        }

        if(idx < size() / 2){
            p = beginMarker.next;
            for(int i = 0; i < idx; i++){
                p = p.next;
            }
        }else{
            p = endMarker;
            for(int i = size() - 1; i > idx; i--){
                p = p.prev;
            }
        }
        return  p;
    }

    private T remove(Node<T> p){
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modeCount++;
        return p.data;
    }

    private class LinkedListIterator implements Iterator<T>{
        private Node<T> current = beginMarker;
        /**
         * 检查迭代期间修改情况
         */
        private int expectedModCount = modeCount;
        private boolean okToRemove = false;


        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {
            if(modeCount != expectedModCount){
                throw new ConcurrentModificationException();
            }

            if(!hasNext()){
                throw new NoSuchElementException();
            }

            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        public void remove(){
            if(modeCount != expectedModCount){
                throw new ConcurrentModificationException();
            }

            if(!okToRemove){
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount ++;
        }
    }
}
