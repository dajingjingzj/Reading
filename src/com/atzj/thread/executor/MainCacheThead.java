package com.atzj.thread.executor;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述：一个任务创建一个线程；
 *  随着程序执行的过程，有的线程执行完了任务，可以被重新循环使用时，才不再创建新的线程来执行任务
 *  让所有的入队任务都执行完毕（shutdown()）
 *  1、主线程的执行与线程池里的线程分开，有可能主线程结束了，但是线程池还在运行
 *  2、放入线程池的线程并不一定会按其放入的先后而顺序执行
 * @author zhoujing129
 * @date 2019/7/17
 */
public class MainCacheThead {
    public static void main(String[] args) {
        System.out.println("Main: Starting at: "+ new Date());
        ExecutorService ex = Executors.newCachedThreadPool(); //创建一个缓冲池，容量大小为Integer.MAX_VALUE
        for (int i=0; i<10; i++){
            ex.execute(new Threademo(String.valueOf(i)));
        }
        ex.shutdown();////执行到此处并不会马上关闭线程池,但之后不能再往线程池中加线程，否则会报错
        System.out.println("Main: Finished all threads at"+ new Date());
    }
}
