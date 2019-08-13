package com.atzj.demobingfa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 类描述：
 *
 * @author zhoujing129
 * @date 2019/7/17
 */
public class Threaddemo {
    Thread thread ;
    static ReentrantLock reentrantLock = new ReentrantLock(); //可重入锁
    ExecutorService executorService; //线程池
    //ThreadPoolExecutor

    public static void main(String[] args) {
        reentrantLock.lock();
        reentrantLock.unlock();
        ReentrantReadWriteLock r  = new ReentrantReadWriteLock();//可冲入读写锁
        r.readLock();//写写，写读互斥；读读不互斥
        r.writeLock();
    }
}
