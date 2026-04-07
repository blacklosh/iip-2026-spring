package org.example.syncronization2;

import lombok.SneakyThrows;

public class Human extends Thread {
    private final CreditCard creditCard;

    public Human(String name, CreditCard creditCard) {
        super(name);
        this.creditCard = creditCard;
    }

    @Override
    @SneakyThrows
    public void run() {
        while (creditCard.getAmount() > 0) {

            synchronized (creditCard) {
                if(creditCard.getAmount() > 0) {
                    System.out.println(Thread.currentThread().getName() + " идёт покупать...");
                    boolean flag = creditCard.buy(1);
                    if(flag) {
                        System.out.println(Thread.currentThread().getName() + " довольный, купил");
                    } else {
                        System.out.println(Thread.currentThread().getName() + " говорит ээээээ");
                    }
                }
                Thread.sleep(1);
            }
        }
    }
}
