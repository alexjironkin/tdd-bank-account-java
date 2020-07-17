package org.xpdojo.bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {
    private int balance;

    public Account() {
        this(0);
    }

    public Account(int startingBalance) {
        /* OpenAccount with positive Balance*/
        balance = startingBalance >= 0 ? startingBalance : 0;
    }

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

    public void withdraw(int amount) {
        /* Withdraw amount */
        if (balance >= amount && amount > 0) {
            balance -= amount;
        }
    }

    public void transfer(Account dest, int amount) {
        if (balance >= amount && amount > 0) {
            this.withdraw(amount);
            dest.deposit(amount);
        }
    }

    public void slip() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        System.out.println(formatter.format(now) + " " + balance);
    }

}
