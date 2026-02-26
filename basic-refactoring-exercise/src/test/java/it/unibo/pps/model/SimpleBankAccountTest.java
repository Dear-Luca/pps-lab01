package it.unibo.pps.model;

/**
 * The test suite for testing the SimpleBankAccount implementation.
 */
public class SimpleBankAccountTest extends AbstractBankAccountTest {

    @Override
    AbstractBankAccount initBankAccount(AccountHolder accountHolder, double initialBalance) {
        return new SimpleBankAccount(accountHolder, initialBalance);
    }

    @Override
    double computeWithdraw(double withdrawAmount) {
        return withdrawAmount;
    }


}
