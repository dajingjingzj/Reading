package com.atzj.thread;

/**
 * 类描述：
 * 也是需要实现 run() 方法，因为 Thread 类也实现了 Runable 接口。
 * @author zhoujing129
 */
public class MyThread extends Thread {
    public void run() {
        System.out.println("白日梦蓝");
    }

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
    }
}
