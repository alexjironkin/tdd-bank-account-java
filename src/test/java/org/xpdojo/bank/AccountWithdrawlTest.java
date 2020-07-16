package org.xpdojo.bank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class AccountWithdrawlTest {
    @Test
    public void singleWithdrawl() {
        Account account = new Account();
        account.deposit(20);
        account.withdrawl(10);

        assertThat(account.balance()).isEqualTo(10);
    }

    @Test
    public void notEnoughFunds() {
        Account account = new Account();
        account.deposit(10);
        account.withdrawl(11);
        assertThat(account.balance()).isEqualTo(10);
    }

    @Test
    public void withdrawNegativeAmount() {
        Account account = new Account();
        account.deposit(10);
        account.withdrawl(-1);
        assertThat(account.balance()).isEqualTo(10);
    }
}
