package org.xpdojo.bank;

public class Account {
    private int balance = 0;

    public int balance() {
        /* Balance of the account */
        return balance;
    }

    public void deposit(int amount) {
        /* Deposit an amount to the account */
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdrawl(int amount) {
        /* Withdraw amount */
        if (balance >= amount && amount > 0) {
            balance -= amount;
        }
    }
}
