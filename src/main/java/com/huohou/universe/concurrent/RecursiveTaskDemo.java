package com.huohou.universe.concurrent;

import java.util.concurrent.RecursiveTask;

/**
 * @Description TODO
 * 最近项目中有个场景是要对一批订单调用银行的接口查询交易凭证，因为各个订单之间是相互独立的，订单量又不固定，研究了一下发现用concurrent
 * 包中提供的RecursiveTask比较好
 * https://www.cnblogs.com/lixuwu/p/7979480.html
 * @Author naikuo
 * @Date 2019/12/2 9:46 PM
 */
public class RecursiveTaskDemo extends RecursiveTask<Integer> {

    private int start;
    private int end;

    private static int COUNT_LIMIT = 50;

    public RecursiveTaskDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int count = end - start;

        if (count < 0) {
            return 0;
        }

        int times = 0;
        if (count <= COUNT_LIMIT) {
            for (int i = start; i <= end; i++) {
                try {
                    System.out.println("调用服务获取凭证:"+i);
                    times++;
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            return times;
        } else {
            //否则fork出其他request
            int mid = (start + end) / 2;
            RecursiveTaskDemo leftTask = new RecursiveTaskDemo(start, mid);
            RecursiveTaskDemo rightTask = new RecursiveTaskDemo(mid + 1, end);
            leftTask.fork(); //调用fork方法将自身放入等待队列中等待执行
            rightTask.fork();

            //等待执行结果
            return leftTask.join() + rightTask.join();
        }
    }
}
