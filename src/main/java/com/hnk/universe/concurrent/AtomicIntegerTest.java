package com.hnk.universe.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author naikuo
 * @Date 2020/2/28 9:29 PM
 */
public class AtomicIntegerTest {
    private static AtomicInteger atomicInteger = new AtomicInteger(3);

//    public static void main(String[] args) {
//        int andIncrement = atomicInteger.getAndIncrement();
//        System.out.println(andIncrement);
//    }

    public static void main(String[] args) {
        System.out.println(atomicInteger.incrementAndGet());
    }
}
