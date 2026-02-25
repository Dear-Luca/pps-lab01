package it.unibo.pps.model;

public class SimpleBankAccountWithFeeTest extends AbstractBankAccountTest{

    @Override
    AbstractBankAccount initBankAccount(AccountHolder accountHolder, double initialBalance) {
        return new SimpleBankAccountWithFee(accountHolder, initialBalance);
    }
}
