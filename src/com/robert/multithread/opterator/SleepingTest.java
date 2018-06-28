package com.robert.multithread.opterator;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTest implements Runnable {

    private int sleepTime = new Random().nextInt(10) + 1;

    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime * 1000);
            System.out.println("睡眠的时间为：" + sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(new SleepingTest());
        }
        service.shutdown();
    }
}
