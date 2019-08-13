package com.atzj.thread;

/**
 * 类描述：
 *
 * @author zhoujing129
 * @date 2019/7/31
 */
public class WaitNotify {
    volatile int a = 0;
    public static void main(String[] args) {
        Object o = new Object();
        WaitNotify waitNotify = new WaitNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    System.out.println("线程1获得监视器锁！！");
                }try {
                    o.wait();
                    System.out.println("线程1正常恢复了~~");
                }catch (InterruptedException e){
                    System.out.println("线程1抛出了InterruptedException异常");
                }
            }
        },"线程1");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    System.out.println("线程2获得监视器锁！！");
                }try {
                    o.wait();
                    System.out.println("线程2正常恢复了~~");
                }catch (InterruptedException e){
                    System.out.println("线程2抛出了InterruptedException异常");
                }
            }
        },"线程2");
        thread2.start();

        // 这里让 thread1 和 thread2 先起来，然后再起后面的 thread3
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    System.out.println("线程3 拿到了监视器锁。");
                    System.out.println("线程3 设置线程1中断");
                    thread1.interrupt(); // 1
                    waitNotify.a = 1; // 这行是为了禁止上下的两行中断和notify代码重排序
                    System.out.println("线程3 调用notify");
                    o.notify(); //2
                    System.out.println("线程3 调用完notify后，休息一会");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("线程3 休息够了，结束同步代码块");
                }
            }
        }, "线程3").start();
    }
}
