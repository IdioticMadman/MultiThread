package com.robert.multithread.threadpool;

import com.robert.multithread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 指定线程池的线程数量，后续的runnable进行排队执行
 */
public class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
