package com.robert.multithread.daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable {


    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 5; i++) {
            service.execute(new DaemonFromFactory());
        }
        System.out.println("All daemons started");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
