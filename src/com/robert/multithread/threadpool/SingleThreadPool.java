package com.robert.multithread.threadpool;

import com.robert.multithread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 只有一个线程的线程池
 */
public class SingleThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executor.execute(new LiftOff());
        }
        executor.shutdown();
    }
}
