package example.model;

public abstract class AbstractBankAccount implements BankAccount{
    private double balance;
    private final AccountHolder holder;

    protected AbstractBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= computeAmount(amount);
        }
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
        }
    }

    protected abstract double computeAmount(double amount);

    private boolean checkUser(final int id) {
        return this.holder.id() == id;
    }

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= computeAmount(amount);
    }

}
