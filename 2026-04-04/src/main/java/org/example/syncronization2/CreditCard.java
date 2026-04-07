package org.example.syncronization2;

public class CreditCard {

    private int amount;

    public CreditCard(int a) {
        amount = a;
    }

    public boolean buy(int cost) {
        if (amount >= cost) {
            amount -= cost;
            return true;
        }
        return false;
    }

    public int getAmount() {
        return amount;
    }

}
