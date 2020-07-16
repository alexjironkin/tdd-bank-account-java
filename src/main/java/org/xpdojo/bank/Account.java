package org.xpdojo.bank;

public class Account {
    private int balance = 0;

    public int balance() {
        /* Balance of the account */
        return balance;
    }

    public void deposit(int amount) {
        /* Deposit an amount to the account */
        balance += amount;
    }
}
