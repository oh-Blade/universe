package com.huohou.universe.concurrent;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

/**
 * 调用服务获取凭证:1
 * 调用服务获取凭证:2
 * 调用服务获取凭证:3
 * 调用服务获取凭证:4
 * 调用服务获取凭证:5
 * 调用服务获取凭证:6
 * 调用服务获取凭证:7
 * 调用服务获取凭证:8
 * 调用服务获取凭证:9
 * 调用服务获取凭证:10
 * 10
 *
 * @Description TODO
 * @Author naikuo
 * @Date 2019/12/10 2:01 PM
 */
public class RecursiveTaskDemoService {

    @Test
    public void testTask(){
        ForkJoinPool forkJoinPool = new ForkJoinPool(64, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);
        RecursiveTaskDemo taskDemo = new RecursiveTaskDemo(1,10);
        Integer invoke = forkJoinPool.invoke(taskDemo);
        System.out.println(invoke);
    }
}
