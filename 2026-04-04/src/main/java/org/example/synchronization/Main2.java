package org.example.synchronization;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        Object sharedObject = new Object();

        new Thread(() -> {
            try {
                for (int i = 0; i < 1_000_000; i++) {
                    synchronized (sharedObject) {
                        System.out.println("A");
                        //Thread.sleep(100);
                        System.out.println("B");
                        //Thread.sleep(100);
                        System.out.println("C");
                        //Thread.sleep(100);
                        System.out.println("D");
                        //Thread.sleep(100);
                        System.out.println("E");
                        //Thread.sleep(100);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                for(int i = 0; i < 1_000_000; i++) {
                    synchronized (sharedObject) {
                        System.out.println("1");
                        //Thread.sleep(100);
                        System.out.println("2");
                        //Thread.sleep(100);
                        System.out.println("3");
                        //Thread.sleep(100);
                        System.out.println("4");
                        //Thread.sleep(100);
                        System.out.println("5");
                        //Thread.sleep(100);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

}
