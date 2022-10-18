import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";

    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList;

    Account() {
        accountNumber = 0;
        balance = 0;
        transactionList = new ArrayList<>();
    }

    Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        transactionList = new ArrayList<>();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * check validity of a withdrawal operation.
     */
    public void doWithdrawing(double amount) throws BankException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else if (amount > balance) {
            throw new InsufficientFundsException(amount);
        } else {
            balance -= amount;
        }
    }

    /**
     * check validity of a depositing operation.
     */
    public void doDepositing(double amount) throws BankException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else {
            balance += amount;
        }
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    /**
     * get account's transaction history.
     */
    public String getTransactionHistory() {
        StringBuilder result = new StringBuilder("Lịch sử giao dịch của tài khoản "
                + accountNumber + ":\n");
        for (Transaction transaction : transactionList) {
            result.append(transaction.getTransactionSummary()).append('\n');
        }
        return result.toString();
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return accountNumber == account.accountNumber;
    }
}
