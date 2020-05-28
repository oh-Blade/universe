package com.universe.concurrency;

/**
 * @Description TODO
 * @Author naikuo
 * @Date 2020/2/16 9:31 PM
 */
public class MyThread extends Thread{
    private MyService myService;
    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
