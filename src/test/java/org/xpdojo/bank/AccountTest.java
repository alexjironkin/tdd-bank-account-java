package org.xpdojo.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        /* This what happens when you don't have fixtures*/
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

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

    @Test
    public void printSlip() {
        Account account = new Account(42);
        account.slip();

        String outputStr = outContent.toString().trim();
        /* I am not dealing with Clock, and Mocking that here for now*/
        assertThat(outputStr.length()).isEqualTo(22);
        /* If only I could do outputStr[:-2] */
        assertThat(outputStr.substring(outputStr.length()-2)).isEqualTo("42");
    }

    @Test
    public void printStatements() {
        Account account = new Account();
        account.deposit(10);
        account.withdraw(10);

        account.printStatement();

        /* list(outContent) <- this is how list should be created with iterable */
        List<String> outputStr = Arrays.asList(outContent.toString().split("\\n"));
        outputStr.replaceAll(String::trim);
        List<String> expected = new ArrayList<String>();
        expected.add("10");
        expected.add("-10");
        assertThat(outputStr).isEqualTo(expected);

    }

    @Test
    public void printDepositStatements() {
        Account account = new Account();
        account.deposit(10);
        account.withdraw(10);

        String filter = "DEPOSIT";

        account.printStatement(filter);

        /* list(outContent) <- this is how list should be created with iterable */
        List<String> outputStr = Arrays.asList(outContent.toString().split("\\n"));
        outputStr.replaceAll(String::trim);
        List<String> expected = new ArrayList<String>();
        expected.add("10");
        assertThat(outputStr).isEqualTo(expected);

    }

    @Test
    public void printWithdrawStatements() {
        Account account = new Account();
        account.deposit(10);
        account.withdraw(10);

        String filter = "WITHDRAW";

        account.printStatement(filter);

        /* list(outContent) <- this is how list should be created with iterable */
        List<String> outputStr = Arrays.asList(outContent.toString().split("\\n"));
        outputStr.replaceAll(String::trim);
        List<String> expected = new ArrayList<String>();
        expected.add("-10");
        assertThat(outputStr).isEqualTo(expected);

    }
}
