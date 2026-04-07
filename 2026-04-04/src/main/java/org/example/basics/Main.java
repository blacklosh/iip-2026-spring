package org.example.basics;

import lombok.SneakyThrows;
import org.example.basics.MyThread;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        MyThread egg = new MyThread("EGG");
        MyThread hen = new MyThread("HEN");

        egg.start();
        hen.start();
    }
}