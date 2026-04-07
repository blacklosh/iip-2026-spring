package org.example.executors;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class SingleThreadMyExecutorService implements MyExecutorService{

    private final List<Runnable> tasks = new ArrayList<>();

    private final WorkerThread workerThread = new WorkerThread();

    public SingleThreadMyExecutorService() {
        workerThread.start();
    }

    private class WorkerThread extends Thread {

        @Override
        @SneakyThrows
        public void run() {
            while (true) {
                Runnable task = null;
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        System.out.println("WorkerThread: нет задач, ложусь спать...");
                        tasks.wait();
                    }
                    System.out.println("WorkerThread: получил задачу");
                    task = tasks.get(0);
                    tasks.remove(task);
                }
                System.out.println("WorkerThread: Делаю задачу");
                task.run();
                System.out.println("WorkerThread: Сделал задачу");
            }
        }
    }

    @Override
    public void accept(Runnable task) {
        synchronized (tasks) {
            tasks.add(task);
            tasks.notify();
        }
    }
}
