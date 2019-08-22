package com.atzj.thread.JVMStore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类描述：
 * 解决线程不安全实例 不加锁的情况下 针对int类型的AtomicIntefer 原子类 保证原子性
 * @author zhoujing129
 */
public class AtomicIntegerSafe {
    private AtomicInteger cnt = new AtomicInteger();
    public void add(){
        cnt.incrementAndGet();
    }
    public int get(){
        return cnt.get();
    }

    public static void main(String[] args) throws InterruptedException{
        final int threadSize = 1000;
        AtomicIntegerSafe atomicIntegerSafe = new AtomicIntegerSafe();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(()->{
                atomicIntegerSafe.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        //1000
        System.out.println(atomicIntegerSafe.get());
    }
}
