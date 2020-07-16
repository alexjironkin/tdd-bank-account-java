package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * I can Deposit money to accounts
 * I can Withdraw money from accounts
 * I can Transfer amounts between accounts (if I have the funds)
 * I can print out an Account balance slip (date, time, balance)
 * I can print a statement of account activity (statement)
 * I can apply Statement filters (include just deposits, withdrawal, date)
 */


public class AccountTest {

    @Test
    public void balanceIsZero() {
        Account account = new Account();
        assertThat(account.balance()).isEqualTo(0);
    }

    @Test
    public void singleDeposit() {
        Account account = new Account();
        account.deposit(10);
        assertThat(account.balance()).isEqualTo(10);
    }

    @Test
    public void multipleDeposits() {
        Account account = new Account();
        account.deposit(10);
        account.deposit(10);
        assertThat(account.balance()).isEqualTo(20);
    }

    @Test
    public void singleNegativeDeposit() {
        Account account = new Account();
        account.deposit(-10);
        assertThat(account.balance()).isEqualTo(-10);
    }

}
