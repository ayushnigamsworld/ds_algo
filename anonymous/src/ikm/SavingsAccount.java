package ikm;

import java.math.BigDecimal;

interface Account {
    BigDecimal balance = new BigDecimal(0.00);
}

public class SavingsAccount implements Account {
    public SavingsAccount(BigDecimal initialValue) {
        //balance = initialValue;
    }

    public String toString() {
        return balance.toString();
    }

    public static void main(String [] args) {
        SavingsAccount savingsAccount = new SavingsAccount(new BigDecimal(50.0));
        System.out.println(savingsAccount);
    }
}
