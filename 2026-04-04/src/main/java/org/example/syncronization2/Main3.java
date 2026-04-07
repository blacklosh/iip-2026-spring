package org.example.syncronization2;

public class Main3 {

    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard(100);

        Human husband = new Human("Муж", creditCard);
        Human wife = new Human("Жена", creditCard);

        husband.start();
        wife.start();
    }
}
