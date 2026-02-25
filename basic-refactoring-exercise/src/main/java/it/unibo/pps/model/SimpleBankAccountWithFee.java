package it.unibo.pps.model;

public class SimpleBankAccountWithFee extends AbstractBankAccount{
    private static final int FEE = 1;

    public SimpleBankAccountWithFee(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    protected double computeAmount(double amount) {
        return amount + FEE;
    }
}
