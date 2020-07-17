package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * I can Deposit money to accounts
 * I can Withdraw money from accounts
 * I can Transfer amounts between accounts (if I have the funds)
 * TODO: I can print out an Account balance slip (date, time, balance)
 * TODO: I can print a statement of account activity (statement)
 * TODO: I can apply Statement filters (include just deposits, withdrawal, date)
 */


public class AccountTest {

    @Test
    public void balanceIsZero() {
        Account account = new Account();
        assertThat(account.balance()).isEqualTo(0);
    }

    @Test
    public void startingBalance() {
        int startingBalance = 100;
        Account account = new Account(startingBalance);
        assertThat(account.balance()).isEqualTo(startingBalance);
    }

    @Test
    public void startingNegativeBalance() {
        Account account = new Account(-1);
        assertThat(account.balance()).isEqualTo(0);
    }
}
