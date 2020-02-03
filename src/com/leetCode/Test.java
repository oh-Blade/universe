package com.leetCode;

/**
 * @Description TODO
 * @Author naikuo
 * @Date 2020/2/3 11:27 PM
 */
public class Test {


    @org.junit.Test
    public void testMyCircularDeque() {
        MyCircularDeque deque = new MyCircularDeque(3);
        deque.insertFront(8);
        deque.insertLast(8);
        deque.insertLast(2);
        deque.getFront();
        deque.deleteLast();
        deque.getRear();
        deque.insertFront(9);
        deque.deleteFront();
        deque.getRear();
        deque.insertLast(2);
        deque.isFull();
    }
}
