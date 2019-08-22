package com.atzj.thread.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类描述： 互斥同步最主要的问题就是线程阻塞和唤醒所带来的性能问题 悲观的并发策略
 * synchronized 是 JVM 实现的，更有优化空间例如自旋锁，而 ReentrantLock 是 JDK API实现的 ,内存消耗大。
 * ReentrantLock 可中断，而 synchronized 不行。
 * synchronized 中的锁是非公平的，ReentrantLock 默认情况下也是非公平的，但是也可以是公平的。
 * 一个 ReentrantLock 可以同时绑定多个 Condition 对象。
 *
 * 使用 synchronized 不用担心没有释放锁而导致死锁问题，因为 JVM 会确保锁的释放。
 * 除非需要使用 ReentrantLock 的高级功能，否则优先使用 synchronized
 * 因为 synchronized 是 JVM 实现的一种锁机制，JVM 原生地支持它，而 ReentrantLock 不是所有的 JDK 版本都支持
 *
 * @author zhoujing129
 */
public class ReentrantLockDemo {
    private Lock lock = new ReentrantLock();
    public void fun() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print(i+" ");
                }
            }finally {
                lock.unlock(); //确认释放锁，避免死锁
            }
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9
        executorService.execute(()->demo.fun());
        executorService.execute(()->demo.fun());
    }
}
