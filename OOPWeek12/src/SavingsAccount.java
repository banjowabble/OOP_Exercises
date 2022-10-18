public class SavingsAccount extends Account {
    SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 1000 && balance - amount >= 5000) {
            try {
                doWithdrawing(amount);
                addTransaction(new Transaction(4, amount, balance + amount, balance));
            } catch (BankException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deposit(double amount) {
        try {
            doDepositing(amount);
            addTransaction(new Transaction(3, amount, balance - amount, balance));
        } catch (BankException e) {
            e.printStackTrace();
        }
    }
}
