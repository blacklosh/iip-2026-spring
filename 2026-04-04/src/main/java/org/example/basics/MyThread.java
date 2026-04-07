package org.example.basics;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i < 100_000; i++) {
            System.out.println(
                    Thread.currentThread().getName()
            );
        }
    }
}
