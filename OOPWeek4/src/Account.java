import java.util.ArrayList;
import java.util.Objects;

public class Account {
    private double balance = 0;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * deposit money.
     * @param amount amount of money
     */
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * withdraw money.
     * @param amount amount of money
     */
    private void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else {
            balance -= amount;
        }
    }

    /**
     * make a new transaction.
     * @param amount amount of money
     * @param operation type of operation
     */
    public void addTransaction(double amount, String operation) {
        if (!Objects.equals(operation, Transaction.DEPOSIT)
                && !Objects.equals(operation, Transaction.WITHDRAW)) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            if (Objects.equals(operation, Transaction.DEPOSIT)) {
                deposit(amount);
            } else {
                withdraw(amount);
            }
            Transaction newTrans = new Transaction(operation, amount, balance);
            transitionList.add(newTrans);
        }
    }

    /**
     * print out all the transactions made.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            if (Objects.equals(transitionList.get(i).getOperation(), Transaction.DEPOSIT)) {
                System.out.print("Giao dich " + (i + 1) + ": Nap tien $");
                System.out.printf("%.2f", transitionList.get(i).getAmount());
                System.out.print(". So du luc nay: $");
                System.out.printf("%.2f", transitionList.get(i).getBalance());
                System.out.println(".");
            } else {
                System.out.print("Giao dich " + (i + 1) + ": Rut tien $");
                System.out.printf("%.2f", transitionList.get(i).getAmount());
                System.out.print(". So du luc nay: $");
                System.out.printf("%.2f", transitionList.get(i).getBalance());
                System.out.println(".");
            }
        }
    }
}
