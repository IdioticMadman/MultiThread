package com.robert.multithread.blockqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    protected BlockingQueue<Object> queue;

    public Producer(BlockingQueue<Object> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Object justProduced = getResource();
                queue.put(justProduced);//生产对象，队列若满则阻塞
                System.out.println("生产者资源队列大小=" + queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("生产者 中断");
            }
        }
    }

    private Object getResource() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("生产者中断");
        }
        return new Object();
    }
}
