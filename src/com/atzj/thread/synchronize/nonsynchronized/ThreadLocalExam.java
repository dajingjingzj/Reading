package com.atzj.thread.synchronize.nonsynchronized;

/**
 * 类描述： 每个 Thread 都有一个 ThreadLocal.ThreadLocalMap 对象。
 * ThreadLocal 从理论上讲并不是用来解决多线程并发问题的，因为根本不存在多线程竞争。
 * 在一些场景 (尤其是使用线程池) 下，由于 ThreadLocal.ThreadLocalMap 的底层数据结构导致 ThreadLocal 有内存泄漏的情况，
 * 应该尽可能在每次使用 ThreadLocal 后手动调用 remove()，以避免出现 ThreadLocal 经典的内存泄漏甚至是造成自身业务混乱的风险。
 *
 * @author zhoujing129
 */
public class ThreadLocalExam {
    public static void main(String[] args) {
        ThreadLocal threadLocal1 = new ThreadLocal();
        ThreadLocal threadLocal2 = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
            threadLocal1.set(1);
            threadLocal2.set(1);
        });
        Thread thread2 = new Thread(() -> {
            threadLocal1.set(2);
            threadLocal2.set(2);
        });
        thread1.start();
        thread2.start();
    }
}
