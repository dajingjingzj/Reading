package com.atzj.thread.executor;

import java.util.Date;


/**
 * 类描述：
 *
 * @author zhoujing129
 * @date 2019/7/17
 */
public class Threademo implements Runnable{

    private String name;
    public Threademo(String name) {
        this.name = "thread"+name;
    }

    @Override
    public void run() {
        System.out.println( name +" Start. Time = "+new Date());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( name +" End. Time = "+new Date());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
