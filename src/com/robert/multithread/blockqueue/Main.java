package com.robert.multithread.blockqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<Object>(5);
        int numProducer = 4;
        int numConsumer = 3;

        for (int i = 0; i < numProducer; i++) {
            new Thread(new Producer(queue)).start();
        }

        for (int i = 0; i < numConsumer; i++) {
            new Thread(new Consumer(queue)).start();
        }

        Thread.sleep(1000);
        System.exit(0);
    }
}
