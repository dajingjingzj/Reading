package com.atzj.thread.synchronize.nonsynchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述：
 * 要保证线程安全，并不是一定就要进行同步。如果一个方法本来就不涉及共享数据，那它自然就无须任何同步措施去保证正确性。
 * 栈封闭
 * 多个线程访问同一个方法的局部变量时，不会出现线程安全问题，因为局部变量存储在虚拟机栈中，属于线程私有的
 * @author zhoujing129
 */
public class StackClosedExample {
    public void add(){
        int cnt =0;
        for (int i = 0; i < 100; i++) {
            cnt++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        StackClosedExample stackClosedExample = new StackClosedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->stackClosedExample.add());//100
        executorService.execute(()->stackClosedExample.add());//100
        executorService.shutdown();
    }
}
