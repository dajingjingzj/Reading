package com.atzj.thread.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述： 互斥同步
 * Java 提供了两种锁机制来控制多个线程对共享资源的互斥访问，第一个是 JVM 实现的 synchronized，而另一个是 JDK 实现的 ReentrantLock。
 * 互斥同步属于一种悲观的并发策略，总是认为只要不去做正确的同步措施，那就肯定会出现问题。无论共享数据是否真的会出现竞争，
 * 它都要进行加锁（这里讨论的是概念模型，实际上虚拟机会优化掉很大一部分不必要的加锁）、用户态核心态转换、维护锁计数器和检查是否有被阻塞的线程需要唤醒等操作。
 * @author zhoujing129
 */
public class SynchronizedDemo {
    /**
     * 同步代码块
     * 之作用于同一个对象，如果调用两个对象上的同步代码块，不会同步
     */
    public void func() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }

        /**
         * 同步一个静态代码块
         * 作用域整个类
         */
       /* public synchronized static void funk() {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }*/
    }
    public static void main(String[] args) {
        SynchronizedDemo e1 = new SynchronizedDemo();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //使用 ExecutorService 执行了两个线程，由于调用的是同一个对象的同步代码块，
        // 因此这两个线程会进行同步，当一个线程进入同步语句块时，另一个线程就必须等待。
        //0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9
        executorService.execute(() -> e1.func());
        executorService.execute(() -> e1.func());

        //两个线程调用了不同对象的同步代码块，因此这两个线程就不需要同步。从输出结果可以看出，两个线程交叉执行。
        // 0 0 1 1 2 2 3 3 4 5 6 7 8 9 4 5 6 7 8 9
        SynchronizedDemo e2 = new SynchronizedDemo();
        SynchronizedDemo e3 = new SynchronizedDemo();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService2.execute(() -> e2.func());
        executorService2.execute(() -> e3.func());
    }
}
