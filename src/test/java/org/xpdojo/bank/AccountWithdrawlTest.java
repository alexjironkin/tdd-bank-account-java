package org.xpdojo.bank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class AccountWithdrawlTest {
    @Test
    public void singleWithdraw() {
        Account account = new Account();
        account.deposit(20);
        account.withdraw(10);

        assertThat(account.balance()).isEqualTo(10);
    }

    @Test
    public void notEnoughFunds() {
        Account account = new Account();
        account.deposit(10);
        account.withdraw(11);
        assertThat(account.balance()).isEqualTo(10);
    }

    @Test
    public void withdrawNegativeAmount() {
        Account account = new Account();
        account.deposit(10);
        account.withdraw(-1);
        assertThat(account.balance()).isEqualTo(10);
    }
}
