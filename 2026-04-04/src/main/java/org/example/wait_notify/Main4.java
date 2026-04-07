package org.example.wait_notify;

public class Main4 {

    public static void main(String[] args) {
        Product product = new Product();

        Producer producer = new Producer(product);
        Consumer consumer = new Consumer(product);

        producer.start();
        consumer.start();
    }
}
