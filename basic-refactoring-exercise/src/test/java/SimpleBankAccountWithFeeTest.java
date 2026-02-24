import example.model.*;
import org.junit.jupiter.api.BeforeEach;

public class SimpleBankAccountWithFeeTest extends AbstractBankAccountTest{

    @Override
    AbstractBankAccount initBankAccount(AccountHolder accountHolder, double initialBalance) {
        return new SimpleBankAccountWithFee(accountHolder, initialBalance);
    }
}
