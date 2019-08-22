package com.atzj.thread.synchronize.nonsynchronized;

/**
 * 类描述：线程本地存储
 * 如果一段代码中所需要的数据必须与其他代码共享，那就看看这些共享数据的代码是否能保证在同一个线程中执行。
 * 如果能保证，我们就可以把共享数据的可见范围限制在同一个线程之内，这样，无须同步也能保证线程之间不出现数据争用的问题
 * 大部分使用消费队列的架构模式（如“生产者-消费者”模式）都会将产品的消费过程尽量在一个线程中消费完
 * 可以使用 java.lang.ThreadLocal 类来实现线程本地存储功能
 *
 * @author zhoujing129
 */
public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        Thread thread1 = new Thread(()->{
            threadLocal.set(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( threadLocal.get());
            threadLocal.remove();
        });
        Thread thread2 = new Thread(()->{
            threadLocal.set(2);
            threadLocal.remove();
        });
        thread1.start();
        thread2.start();//1
    }
}
