package com.atzj.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述：
 * 调用 Executor 的 shutdown() 方法会等待线程都执行完毕之后再关闭，
 * 但是如果调用的是 shutdownNow() 方法，则相当于调用每个线程的 interrupt() 方法。
 * @author zhoujing129
 */
public class ShutDownDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() ->{ //使用 Lambda 创建线程，相当于创建了一个匿名内部线程。
            try {
                Thread.sleep(2000);
                System.out.println("线程run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
       // executorService.shutdown();
        executorService.shutdownNow();
        System.out.println("Main run");
    }
}
