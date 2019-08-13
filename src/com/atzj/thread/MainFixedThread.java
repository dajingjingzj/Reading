package com.atzj.thread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述：
 * 使用一个优先固定数目的线程来处理若干数目的任务 规定数目的线程处理所有任务，一旦有线程处理完了任务就会被用来处理新的任务(如果有的话)
 * CachedThreadPool模式下处理一定数量的任务的线程数目是不确定的。而FixedThreadPool模式下最多 的线程数目是一定的
 * 上面创建了一个固定大小的线程池，大小为5.也就说同一时刻最多只有5个线程能运行。
 * 并且线程执行完成后就从线程池中移出。它也不能保证放入的线程能按顺序执行。这要看在等待运行的线程的竞争状态了。
 *
 * @author zhoujing129
 * @date 2019/7/17
 */
public class MainFixedThread {
    public static void main(String[] args) {
        System.out.println("Main: Starting at: "+ new Date());
        ExecutorService ex = Executors.newFixedThreadPool(5);
        for (int i=0; i<10; i++){
            ex.execute(new Threademo(String.valueOf(i)));
        }
        ex.shutdown();////执行到此处并不会马上关闭线程池,但之后不能再往线程池中加线程，否则会报错
        System.out.println("Main: Finished all threads at"+ new Date());
    }
}
