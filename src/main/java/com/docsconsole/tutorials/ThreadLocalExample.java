package com.docsconsole.tutorials;

public class ThreadLocalExample {

    public static void main(String[] args) {

        RunnableExample runnableExample = new RunnableExample();

        Thread t1 = new Thread(runnableExample);
        t1.setName("Thread - 1");
        Thread t2 = new Thread(runnableExample);
        t2.setName("Thread - 2");
        // this will call run() method
        t1.start();
        t2.start();
    }

    public static class RunnableExample implements Runnable {

        private final ThreadLocal<String> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(threadLocal.get());
        }

    }



}