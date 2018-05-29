package com.company;

public class TestThread extends Thread {

    private long delay;
    private ICallback handler;

    public TestThread(String name, long delay, ICallback handler) {
        super(name);
        this.delay = delay;
        this.handler = handler;
    }

    @Override
    public void run() {
//        super.run();
        try {
            Thread.sleep(delay);
            if (handler != null) {
                handler.doCallback(getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
