package com.company;

public class Main implements ICallback {

    private UIThread uiThread;

    public static void main(String[] args) {
        Main main = new Main();
        main.runTheApp();
    }

    private void runTheApp() {

        uiThread = new UIThread(); // пункт 3
        uiThread.start(); // пункт 3

        //сперва сделать без этих вызовов doCallback
        doCallback("test string 1"); // do after
        for (int i = 1; i < 5; i++) {
            Thread thread = new TestThread("thread" + i,  3000 * i, this);
            thread.start();
        }
        doCallback("test string 2"); // do after
    }

    @Override
    public void doCallback(String s) {
        System.out.println(String.format("%s sent from %s thread", s, Thread.currentThread().getName()));
        uiThread.ruOnUIThread(new Runnable() { // пункт 3
            @Override
            public void run() {
                System.out.println(String.format("task performed in %s thread context", Thread.currentThread().getName()));
            }
        });
//        System.out.println("callback from :" + s);
    }
}
