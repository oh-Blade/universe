package com.leetCode;

import java.util.LinkedHashMap;

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

    @org.junit.Test
    public void testLinkedHashMap() {
        LinkedHashMap map = new LinkedHashMap();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        System.out.println(map);

        LinkedHashMap map1 = new LinkedHashMap(16, 0.75f, true);
        map1.put("a", "1");
        map1.put("b", "2");
        map1.put("c", "3");
        System.out.println(map1);
        map1.get("b");
        map1.get("a");
        map1.get("c");
        System.out.println(map1);
    }

    @org.junit.Test
    public void testLRUCache() {

        LinkedHashMap map1 = new LRUCache(2);
        map1.put("a", "1");
        map1.put("b", "2");
        map1.put("c", "3");
        System.out.println(map1);
        map1.get("b");
        map1.get("a");
        map1.get("c");
        System.out.println(map1);
    }
}
