package org.example.wait_notify;

import lombok.SneakyThrows;

public class Producer extends Thread {

    private final Product product;

    public Producer(Product p) {
        product = p;
    }

    @Override
    @SneakyThrows
    public void run() {
        while (true) {
            // дожидаемся, чтобы продукт употребили
            synchronized (product) {
                while (!product.isConsumed()) {
                    System.out.println("Producer: жду, пока продукт употребят");
                    // ждать, пока его употребят
                    product.wait();
                }
                System.out.println("Producer: продукт употребили! Произвожу его...");
                // ура, продукт употребили. нужно его произвести
                product.produce();
                Thread.sleep(1000);
                System.out.println("Producer: успешно произвёл продукт!");
                product.notify();
            }
        }
    }
}
