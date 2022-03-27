package com.huohou.universe.sychronized;

import com.huohou.universe.future.HnkCompletableFuture;

/**
 * @author naikuoh
 * @DATE 2020/7/24 13:34
 */
public class Example {


    /**
     * 在synchronized代码块中，新起一个线程执行，新线程执行任务不影响sychronized代码块继续执行
     * 结果：
     *  第一个锁执行完毕
     * 新线程执行
     * 第二个锁执行完毕
     * 新线程执行完毕
     * end
     * <p>
     * 新线程执行
     * 第一个锁执行完毕
     * 第二个锁执行完毕
     * end
     * 新线程执行完毕
     */
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

}
