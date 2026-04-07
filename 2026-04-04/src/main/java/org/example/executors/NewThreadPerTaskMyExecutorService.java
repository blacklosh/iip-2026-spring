package org.example.executors;

public class NewThreadPerTaskMyExecutorService implements MyExecutorService {
    @Override
    public void accept(Runnable runnable) {
        new Thread(runnable).start();
    }
}
