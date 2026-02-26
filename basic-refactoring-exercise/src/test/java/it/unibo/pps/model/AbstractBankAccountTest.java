package it.unibo.pps.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractBankAccountTest {
    private static final double INITIAL_BALANCE = 0;
    private static final double AMOUNT = 100;
    private static final double WITHDRAW_AMOUNT = 70;
    private static final int ID = 1;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", ID);
        bankAccount = initBankAccount(accountHolder, INITIAL_BALANCE);
    }

    abstract AbstractBankAccount initBankAccount(AccountHolder accountHolder, double initialBalance);

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.id(), AMOUNT);
        assertEquals(AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        final int amount = 50;
        bankAccount.deposit(accountHolder.id(), AMOUNT);
        bankAccount.deposit(ID + 1, amount);
        assertEquals(AMOUNT, bankAccount.getBalance());
    }

    void depositAndWithDraw(int id){
        bankAccount.deposit(accountHolder.id(), AMOUNT);
        bankAccount.withdraw(id, WITHDRAW_AMOUNT);
    }

    @Test
    void testWithdraw(){
        depositAndWithDraw(accountHolder.id());
        assertEquals(AMOUNT - computeWithdraw(WITHDRAW_AMOUNT), bankAccount.getBalance());
    }


    abstract double computeWithdraw(double withdrawAmount);

    @Test
    void testWrongWithdraw() {
        depositAndWithDraw(ID + 1);
        assertEquals(AMOUNT, bankAccount.getBalance());
    }

}
