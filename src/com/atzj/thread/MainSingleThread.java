package com.atzj.thread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述：
 * 创建只能运行一条线程的线程池。它能保证线程的先后顺序执行，并且能保证一条线程执行完成后才开启另一条新的线程
 * 等价于 ExecutorService exec = Executors.newFixedThreadPool(1);
 *
 * @author zhoujing129
 * @date 2019/7/17
 */
public class MainSingleThread {
    public static void main(String[] args) {

        System.out.println("Main Thread: Starting at: " + new Date());
        ExecutorService exec = Executors.newSingleThreadExecutor();   //创建大小为1的固定线程池
        for (int i = 0; i < 10; i++) {
            exec.execute(new Threademo(String.valueOf(i)));
        }
        exec.shutdown();  //执行到此处并不会马上关闭线程池
        System.out.println("Main Thread: Finished at:" + new Date());
    }
}
