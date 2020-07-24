package com.hnk.universe.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

/**
 * @author naikuoh
 * @DATE 2020/6/12 15:45
 */
public class HnkCompletionStageWrapper<T> extends CompletableFuture<T> {

    private CompletableFuture<T> delegated;

    private ExecutorService executorService = FutureConverter.canaanForkJoinExecutor();

    public HnkCompletionStageWrapper() {
        super();
    }

    public HnkCompletionStageWrapper(CompletableFuture<T> delegated) {
        this.delegated = getWrappedStage(delegated);
        this.delegated.whenCompleteAsync((response, error) -> {
            if (error != null) {
                this.completeExceptionally(error);
            } else {
                this.complete(response);
            }
        }, executorService);
    }

    public CompletableFuture<T> getDelegated() {
        return delegated;
    }

    private CompletableFuture<T> getWrappedStage(CompletableFuture<T> parent) {
        if (parent instanceof HnkCompletionStageWrapper) {
            return getWrappedStage(((HnkCompletionStageWrapper) parent).getDelegated());
        } else {
            return parent;
        }
    }

}
