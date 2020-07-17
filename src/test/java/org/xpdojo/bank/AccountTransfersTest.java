package org.xpdojo.bank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class AccountTransfersTest {

    @Test
    public void transferFunds() {
        Account source = new Account(10);
        Account dest = new Account(10);

        source.transfer(dest, 5);

        assertThat(source.balance()).isEqualTo(5);
        assertThat(dest.balance()).isEqualTo(15);

    }

    @Test
    public void transferInsufficientFunds() {
        Account source = new Account(10);
        Account dest = new Account(10);

        source.transfer(dest, 100);

        assertThat(source.balance()).isEqualTo(10);
        assertThat(dest.balance()).isEqualTo(10);
    }

    @Test
    public void transferNegativeFunds() {
        Account source = new Account(10);
        Account dest = new Account(10);

        source.transfer(dest, -10);

        assertThat(source.balance()).isEqualTo(10);
        assertThat(dest.balance()).isEqualTo(10);
    }
}
