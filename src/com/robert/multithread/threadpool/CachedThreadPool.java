package com.robert.multithread.threadpool;

import com.robert.multithread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 根据Runnable的个数创建对应大小的线程池
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
