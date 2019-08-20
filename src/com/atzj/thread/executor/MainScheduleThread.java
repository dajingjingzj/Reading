package com.atzj.thread.executor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 类描述：
 * 设置线程执行的先后间隔及执行时间等，功能比上面的三个强大了一些
 * 实现每个放入的线程延迟10秒执行。
 *
 * execute() 表示往线程池添加线程，有可能会立即运行，也有可能不会。无法预知线程何时开始，何时线束。
 * shutdown() 通常放在execute后面。如果调用 了这个方法，一方面，表明当前线程池已不再接收新添加的线程，新添加的线程会被拒绝执行。
 * 另一方面，表明当所有线程执行完毕时，回收线程池的资源。注意，它不会马上关闭线程池！
 * shutdownNow() 不管有没有线程在执行，立刻关闭线程池
 * @author zhoujing129
 * @date 2019/7/17
 */
public class MainScheduleThread {
    public static void main(String[] args) {
        System.out.println("Main Thread: Starting at: " + new Date());
        ScheduledThreadPoolExecutor exec = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);   //创建大小为10的线程池
        for (int i = 0; i < 10; i++) {
            // exec.schedule(new Threademo(String.valueOf(i)), 10, TimeUnit.SECONDS);//延迟10秒执行
            //  exec.scheduleAtFixedRate(new Threademo(String.valueOf(i)),0,2000,TimeUnit.MILLISECONDS);//初始化延迟0ms开始执行，每隔2000ms重新执行一次任务
            exec.scheduleWithFixedDelay(new Threademo(String.valueOf(i)), 0, 2000, TimeUnit.MILLISECONDS);//间隔指的是连续上次执行完成和下次开始执行之间的间隔
        }
        exec.shutdown();  //执行到此处并不会马上关闭线程池
        while (!exec.isTerminated()) {
            //wait for all tasks to finish
        }
        System.out.println("Main Thread: Finished at:" + new Date());
    }
}
