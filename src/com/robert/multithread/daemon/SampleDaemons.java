package com.robert.multithread.daemon;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程示例
 */
public class SampleDaemons implements Runnable {

    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                System.out.println("sleep() interrupt");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SampleDaemons());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
