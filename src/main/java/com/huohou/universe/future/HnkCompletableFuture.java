package com.huohou.universe.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

/**
 * @author naikuoh
 * @DATE 2020/5/10 20:54
 */
public class HnkCompletableFuture<T> extends HnkCompletionStageWrapper<T> {

    public HnkCompletableFuture(CompletionStage<T> future) {
        super(future.toCompletableFuture());
    }

    public static CompletableFuture<Void> runAsync(Runnable runnable) {
        return runAsync(runnable, FutureConverter.canaanForkJoinExecutor());
    }

    public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier) {
        return new HnkCompletableFuture(supplyAsync(supplier, FutureConverter.canaanForkJoinExecutorContext()));
    }
}
