package com.robert.multithread;

public class MoreBasicThread {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting for com.robert.multithread.LiftOff");
    }
}
