package com.hnk.universe.concurrent;

import com.hnk.universe.future.HnkCompletableFuture;

/**
 * @author naikuoh
 * @DATE 2020/7/24 12:21
 */
public class SynchronizedExample {
    @org.junit.Test
    public void testSychronized() throws InterruptedException {
        Object o = new Object();
        synchronized (o) {
            HnkCompletableFuture.runAsync(() -> {
                System.out.println("新线程执行");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("新线程执行完毕");

            });
            System.out.println("第一个锁执行完毕");
        }
        synchronized (o) {
            System.out.println("第二个锁执行完毕");
        }

        Thread.sleep(10000);
        System.out.println("end");
    }
    /**
     * 第一个锁执行完毕
     * 新线程执行
     * 第二个锁执行完毕
     * 新线程执行完毕
     * end
     *
     * 新线程执行
     * 第一个锁执行完毕
     * 第二个锁执行完毕
     * end
     * 新线程执行完毕
     */
}
