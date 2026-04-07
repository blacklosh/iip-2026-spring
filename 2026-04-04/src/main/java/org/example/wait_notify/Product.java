package org.example.wait_notify;

public class Product {

    private boolean isProduced;

    public Product() {
        isProduced = true;
    }

    public boolean isProduced() {
        return isProduced;
    }

    public boolean isConsumed() {
        return !isProduced;
    }

    public void produce() {
        isProduced = true;
    }

    public void consume() {
        isProduced = false;
    }

}
