package com.huohou.universe.future;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author naikuoh
 * @DATE 2020/6/12 16:21
 */
public class HnkFuture {

    public static <U> Future<U> runAsync(Callable<U> callable) {
        ExecutorService executorService = FutureConverter.canaanCommonExecutorPool();
        return executorService.submit(callable);
    }
}
