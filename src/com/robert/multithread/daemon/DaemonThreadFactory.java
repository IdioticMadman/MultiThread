package com.robert.multithread.daemon;

import java.util.concurrent.ThreadFactory;

/**
 * 生成后台线程的工厂
 */
public class DaemonThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
