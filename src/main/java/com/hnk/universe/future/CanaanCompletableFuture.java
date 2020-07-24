package com.hnk.universe.future;

import com.canaan.lib.future.FutureConverter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

/**
 * @author naikuoh
 * @DATE 2020/5/10 20:54
 */
public class CanaanCompletableFuture<T> extends CanaanCompletionStageWrapper<T> {

    public CanaanCompletableFuture(CompletionStage<T> future) {
        super(future.toCompletableFuture());
    }

    public static CompletableFuture<Void> runAsync(Runnable runnable) {
        return runAsync(runnable, FutureConverter.canaanForkJoinExecutor());
    }

    public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier) {
        return new com.canaan.lib.future.CanaanCompletableFuture(supplyAsync(supplier, FutureConverter.canaanForkJoinExecutorContext()));
    }
}
