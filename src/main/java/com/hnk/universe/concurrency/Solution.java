package com.hnk.universe.concurrency;

import java.io.IOException;

/**
 * @Description TODO
 * @Author naikuo
 * @Date 2020/2/16 9:32 PM
 */
public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {

        MyService myService = new MyService();

        MyThread myThreadA = new MyThread(myService);
        MyThread myThreadB = new MyThread(myService);
        MyThread myThreadC = new MyThread(myService);

        myThreadA.start();
        myThreadB.start();
        myThreadC.start();

    }
}
