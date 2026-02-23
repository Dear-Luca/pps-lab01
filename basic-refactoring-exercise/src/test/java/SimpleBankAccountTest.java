import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private static final double INITIAL_BALANCE = 0;
    private static final double AMOUNT = 100;
    private static final double WITHDRAW_AMOUNT = 70;
    private static final int FEE = 1;
    private static final int ID = 1;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", ID);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);
    }

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
    void testWithdraw() {
        depositAndWithDraw(accountHolder.id());
        assertEquals(AMOUNT - WITHDRAW_AMOUNT - FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        depositAndWithDraw(ID + 1);
        assertEquals(AMOUNT, bankAccount.getBalance());
    }
}
