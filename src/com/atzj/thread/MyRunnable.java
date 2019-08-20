package com.atzj.thread;

/**
 * 类描述：
 * 实现Runnable接口，要实现run 方法
 * @author zhoujing129
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("大静静");
        try {
            //sleep() 可能会抛出 InterruptedException，因为异常不能跨线程传播回 main() 中，因此必须在本地进行处理
            Thread.sleep(3000); //会休眠当前正在执行的线程，millisec 单位为毫秒。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //对静态方法 Thread.yield() 的调用声明了当前线程已经完成了生命周期中最重要的部分，可以切换给其它线程来执行。
        // 该方法只是对线程调度器的一个建议，而且也只是建议具有相同优先级的其它线程可以运行。
        Thread.yield();
    }

    /**
     * 实现接口会更好一些，因为：
     * Java 不支持多重继承，因此继承了 Thread 类就无法继承其它类，但是可以实现多个接口；
     * 类可能只要求可执行就行，继承整个 Thread 类开销过大。
     * @param args
     */

    public static void main(String[] args) {
        //实现 Runnable 和 Callable 接口的类只能当做一个可以在线程中运行的任务，
        // 不是真正意义上的线程，因此最后还需要通过 Thread 来调用。可以说任务是通过线程驱动从而执行的。
        MyRunnable runnable = new MyRunnable();
        Thread thread  = new Thread(runnable); //最终还是要调用thread的 start() 方法来启动线程
        thread.start();

        thread.setDaemon(true);//设置线程为守护线程 main()属于非守护线程
        // 守护线程是程序运行时在后台提供服务的线程，不属于程序中不可或缺的部分。
        //当所有非守护线程结束时，程序也就终止，同时会杀死所有守护线程。
    }
}
