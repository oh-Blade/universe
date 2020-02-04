package com.leetCode;

import java.util.*;

/**
 * @Description TODO
 * @Author naikuo
 * @Date 2020/2/3 11:27 PM
 */
public class Test {

    @org.junit.Test
    public void testDeque() {
        /**
         * 堆栈
         */
        Deque<String> stack = new ArrayDeque<>();
        //入栈
        stack.push("a");
        stack.push("b");

        //出栈
        stack.pop();

        //取栈顶
        stack.peek();
        stack.peekFirst();
        //取栈底
        stack.peekLast();

        stack.contains("b");
        stack.isEmpty();
        stack.size();

        /**
         * 单项队列
         */
        Deque<String> queue = new ArrayDeque<>();
        //进队列
        queue.offer("a");
        queue.offer("b");

        //出队列
        queue.poll();
        //取队首和队尾
        queue.peekFirst();
        queue.peekLast();

        queue.contains("b");
        queue.isEmpty();
        queue.size();

        /**
         * 双端队列
         */
        Deque<String> deque = new ArrayDeque<>();
        //队首队尾插入
        deque.offerFirst("a");
        deque.offerLast("b");
        //取队首队尾
        deque.peekFirst();
        deque.peekLast();

        deque.contains("b");
        deque.size();
        deque.isEmpty();


    }

    @org.junit.Test
    public void testMinStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(5);
        stack.push(2);
        System.out.println(stack);
    }

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
