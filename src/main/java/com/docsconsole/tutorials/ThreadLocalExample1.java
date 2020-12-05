package com.docsconsole.tutorials;

public class ThreadLocalExample1 {
    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        Thread thread1 = new Thread(() -> {
            System.out.println(":::: In thread 1 :::::");
            threadLocal.set("Thread - 1");
            inheritableThreadLocal.set("Thread - 1");

            System.out.println("threadLocal@thread1: " + threadLocal.get());
            System.out.println("inheritableThreadLocal@thread1: " + inheritableThreadLocal.get());

            Thread childThread = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(":::::: In  ChildThread :::::::");
                System.out.println("threadLocal@childThread: " + threadLocal.get());
                System.out.println("inheritableThreadLocal@childThread: " + inheritableThreadLocal.get());

            });
            childThread.start();
        });

        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(":::::: In  thread2 :::::::");
            System.out.println("threadLocal@thread2: " + threadLocal.get());
            System.out.println("inheritableThreadLocalthread2: " + inheritableThreadLocal.get());

        });
        thread2.start();
    }

}
