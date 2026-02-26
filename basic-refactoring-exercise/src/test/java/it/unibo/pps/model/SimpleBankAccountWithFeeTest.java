package it.unibo.pps.model;

public class SimpleBankAccountWithFeeTest extends AbstractBankAccountTest{
    private static final int FEE = 1;

    @Override
    AbstractBankAccount initBankAccount(AccountHolder accountHolder, double initialBalance) {
        return new SimpleBankAccountWithFee(accountHolder, initialBalance);
    }

    @Override
    double computeWithdraw(double withdrawAmount) {
        return withdrawAmount + FEE;
    }
}
