package com.atzj.thread;

/**
 * 类描述： 綫程
 * 在线程中调用另一个线程的 join() 方法，会将当前线程挂起，而不是忙等待，直到目标线程结束。
 * @author zhoujing129
 */
public class JoinDemo {
    private class A extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class B extends Thread {

        private A a;

        B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test() {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }

    /**
     * 虽然 b 线程先启动，但是因为在 b 线程中调用了 a 线程的 join() 方法，
     * b 线程会等待 a 线程结束才继续执行，因此最后能够保证 a 线程的输出先于 b 线程的输出。
     * @param args
     */
    public static void main(String[] args) {
        JoinDemo joinDemo = new JoinDemo();
        //A B
        joinDemo.test();
    }
}
