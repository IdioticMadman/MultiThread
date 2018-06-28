package com.robert.multithread.callable;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 可以返回结果的异步
 * 不同于Runnable返回值为void
 */
class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        return "result of com.robert.multithread.callable.TaskWithResult " + id;
    }
}

public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(5, 10, 5000, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            results.add(service.submit(new TaskWithResult(i)));
        }
        for (Future<String> result : results) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                service.shutdown();
            }
        }
    }
}
