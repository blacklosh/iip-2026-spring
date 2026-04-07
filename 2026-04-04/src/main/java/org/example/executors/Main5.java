package org.example.executors;

import lombok.SneakyThrows;

import java.util.Scanner;

public class Main5 {

    @SneakyThrows
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        MyExecutorService executorService = new FixedThreadPoolMyExecutorService(2);

        Runnable task1 = () -> {
            for(int i = 0; i < 100_000; i++) {
                System.out.println("Step = " + i);
            }
        };

        while (true) {
            scanner.nextLine();
            executorService.accept(task1);
        }
    }
}
