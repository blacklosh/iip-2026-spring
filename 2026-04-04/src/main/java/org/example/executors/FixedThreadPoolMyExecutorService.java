package org.example.executors;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class FixedThreadPoolMyExecutorService implements MyExecutorService{

    private final List<Runnable> tasks = new ArrayList<>();

    private final List<WorkerThread> workerThreads = new ArrayList<>();

    public FixedThreadPoolMyExecutorService(int number) {
        for(int i = 0; i < number; i++) {
            WorkerThread workerThread = new WorkerThread(i);
            workerThreads.add(workerThread);
            workerThread.start();
        }
    }

    private class WorkerThread extends Thread {

        private final int num;

        public WorkerThread(int n) {
            num = n;
        }

        @Override
        @SneakyThrows
        public void run() {
            while (true) {
                Runnable task = null;
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        System.out.println("WorkerThread" + num + ": нет задач, ложусь спать...");
                        tasks.wait();
                    }
                    System.out.println("WorkerThread" + num + ": получил задачу");
                    task = tasks.get(0);
                    tasks.remove(task);
                }
                System.out.println("WorkerThread" + num + ": Делаю задачу");
                task.run();
                System.out.println("WorkerThread" + num + ": Сделал задачу");
            }
        }
    }

    @Override
    public void accept(Runnable task) {
        synchronized (tasks) {
            tasks.add(task);
            tasks.notifyAll();
        }
    }
}
