package com.huohou.universe.algorithm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author naikuo
 * @Date 2020/2/23 7:40 PM
 */
public class PrintOddAndEven {

    public static volatile boolean flag = false;

    public static AtomicInteger num = new AtomicInteger();

    public static void main(String[] args) {
        new Thread(() -> {
            while (num.get() < 100) {
                if (flag) {
                    System.out.println(Thread.currentThread() + "->" + num.getAndIncrement());
                    flag = true;
                }

            }
        }, "奇数").start();
        new Thread(() -> {
            while (num.get() < 100) {
                if (!flag) {
                    System.out.println(Thread.currentThread() + "->" + num.getAndIncrement());
                    flag = false;
                }
            }
        }, "偶数").start();
    }
}
