package com.hnk.universe.future

import java.util.concurrent.{ExecutorService, ForkJoinPool, LinkedBlockingQueue, ThreadFactory, ThreadPoolExecutor, TimeUnit}

import com.google.common.util.concurrent.ThreadFactoryBuilder

import scala.concurrent.ExecutionContext

/**
 * @author naikuoh
 * @DATE 2020/5/22
 */
object FutureConverter {
  implicit lazy val canaanForkJoinExecutor: ExecutorService = {
    new ForkJoinPool(64, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true)
  }
  lazy val canaanForkJoinExecutorContext = ExecutionContext.fromExecutorService(canaanForkJoinExecutor)

  implicit lazy val canaanCommonExecutorPool: ExecutorService = {
    val namedThreadFactory: ThreadFactory = new ThreadFactoryBuilder().setNameFormat("default-async-worker-pool-%d").build
    new ThreadPoolExecutor(10,
      500,
      30000L,
      TimeUnit.MILLISECONDS,
      new LinkedBlockingQueue[Runnable](10),
      namedThreadFactory,
      new ThreadPoolExecutor.AbortPolicy)
  }
}

trait CanaanExecutorContext {
  implicit lazy val canaanExecutionContextExecutor = FutureConverter.canaanForkJoinExecutorContext
}
