package com.company;

import java.util.concurrent.ConcurrentLinkedQueue;

//пункт 3
public class UIThread extends Thread {

    private boolean isRunning;
    private ConcurrentLinkedQueue<Runnable> concurrentLinkedQueue;

    @Override
    public void run() {
        isRunning = true;
        while (isRunning) {
            try {

                Runnable runnable = concurrentLinkedQueue.poll();
                if (runnable != null) {
                    runnable.run();
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                isRunning = false;
                e.printStackTrace();
            }
        }
    }

    public UIThread() {
        super("UIThread");
        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
    }

    public void ruOnUIThread(Runnable runnable) {
        System.out.println(String.format("ruOnUIThread called in %s thread context", Thread.currentThread().getName()));
//        runnable.run();
        concurrentLinkedQueue.offer(runnable);

    }
}
