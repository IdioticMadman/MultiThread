package com.robert.multithread.blockqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<Object> mQueue;

    public Consumer(BlockingQueue<Object> queue) {
        mQueue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object obj = mQueue.take();//消费对象，如果没有对象则阻塞
                System.out.println("消费者资源队列大小" + mQueue.size());
                take(obj);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("消费者被打断");
        }
    }

    private void take(Object obj) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("消费者读中断");
        }
        System.out.println("消费对象" + obj);
    }
}
