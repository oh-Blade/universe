package com.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author naikuo
 * @Date 2020/2/16 9:30 PM
 */
public class MyService {
    private Lock lock = new ReentrantLock();

    public void testMethod() {
        lock.lock();

        for (int i = 0; i < 5; i++){
            System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
        }

        lock.unlock();

    }
}
