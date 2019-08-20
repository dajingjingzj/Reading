package com.atzj.thread.executor;

import com.atzj.thread.MyRunnable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述： 基础线程机制
 * Executor 管理多个异步任务的执行，而无需程序员显式地管理线程的生命周期。
 * 这里的异步是指多个任务的执行互不干扰，不需要进行同步操作。
 * @author zhoujing129
 */
public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }
}
