public class ClientTest {
    public static void main(String[] args) {
        Account acc = new Account();

        //test normal cases
        acc.addTransaction(10000, "deposit");
        acc.addTransaction(2000, "withdraw");

        //test abnormal cases
        acc.addTransaction(9000, "withdraw");
        acc.addTransaction(1000, "depo");
        acc.addTransaction(-1000, "deposit");
        acc.addTransaction(-1000, "withdraw");

        //print out all the transactions made
        acc.printTransaction();
    }
}
