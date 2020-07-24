package com.hnk.universe.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Description TODO
 * @Author naikuo
 * @Date 2020/2/28 4:41 PM
 */
public class SemaphoreTest {
    private final static int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        Thread.sleep(3000);
                        System.out.println("i->");
                        semaphore.release();
                    } catch (InterruptedException e) {

                        System.out.println(e.getMessage());
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
