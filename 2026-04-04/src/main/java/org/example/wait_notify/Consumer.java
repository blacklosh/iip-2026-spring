package org.example.wait_notify;

import lombok.SneakyThrows;

public class Consumer extends Thread {

    private final Product product;

    public Consumer(Product p) {
        product = p;
    }

    @Override
    @SneakyThrows
    public void run() {
        while (true) {
            synchronized (product) {
                // дожидаемся, чтобы продукт произвели
                while (!product.isProduced()) {
                    System.out.println("Consumer: жду, пока продукт произведут");
                    // ждать, пока его произведут
                    product.wait();
                }
                System.out.println("Consumer: продукт произвели! Употребляю его...");
                // ура, продукт произвели. нужно его употребить
                product.consume();
                Thread.sleep(1000);
                System.out.println("Consumer: успешно употребил продукт!");
                product.notify();
            }
        }
    }
}
