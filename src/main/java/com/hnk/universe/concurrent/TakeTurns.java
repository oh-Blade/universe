package com.hnk.universe.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程，轮流分别打印1-26 和a-z
 *
 * @author naikuoh
 * @DATE 2020/5/16 17:09
 */
public class TakeTurns {
    static String[] ayy = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static void turn1() {
        final Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                for (int i = 1; i <= 26; i++) {
                    o.notify();
                    System.out.println(i);
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }).start();

        new Thread(() -> {
            synchronized (o) {

                for (String s : ayy) {
                    o.notify();
                    System.out.println(s);
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }).start();
    }

    static Thread t1, t2 = null;

    public static void turn2() {
        char[] num = "1234567".toCharArray();
        char[] cha = "abcdefg".toCharArray();
        t1 = new Thread(() -> {
            for (char c : num) {
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");
        t2 = new Thread(() -> {
            for (char c : cha) {
                System.out.println(c);
                LockSupport.park();
                LockSupport.unpark(t1);
            }
        }, "t2");
        t1.start();
        t2.start();

    }

    public static void main(String[] args) {
        turn2();
    }
}
