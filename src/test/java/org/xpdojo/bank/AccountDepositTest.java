package org.xpdojo.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountDepositTest {
    @Test
    public void singleDeposit() {
        Account account = new Account();
        account.deposit(10);
        assertThat(account.balance()).isEqualTo(10);
    }

    @Test
    public void Deposits() {
        Account account = new Account();
        account.deposit(10);
        account.deposit(10);
        assertThat(account.balance()).isEqualTo(20);
    }

    @Test
    public void singleNegativeDeposit() {
        Account account = new Account();
        account.deposit(-10);
        assertThat(account.balance()).isEqualTo(0);
    }
}
